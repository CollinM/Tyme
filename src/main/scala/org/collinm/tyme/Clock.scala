package org.collinm.tyme

import scala.swing.SwingApplication
import scala.swing.MainFrame
import java.awt.Color
import scala.swing.BoxPanel
import scala.swing.Orientation
import java.awt.Graphics2D
import java.awt.geom.Ellipse2D
import java.awt.BasicStroke
import scala.swing.event.Event
import scala.swing.Publisher
import java.awt.Dimension
import java.awt.RenderingHints
import java.awt.geom.Line2D
import org.collinm.tyme.utils.Geometry
import org.collinm.tyme.utils.Time

/** Main runtime */
object Clock extends SwingApplication {
    
    def startup(args: Array[String]) = {
        val frame = new ClockFrame()
        frame.visible = true
        //frame.peer.setUndecorated(true)  // Remove title bar
    }
}

/** The main window frame that houses the clock.
 *  
 *  Creates and owns the clock and it's refresh timer.  Automatically maximizes
 *  itself on creation and instantiates a clock that fits nicely inside the frame
 *  (centered).
 */
class ClockFrame extends MainFrame {
    this.maximize()
    val clock = new ElegantClockPanel(this.toolkit.getScreenSize())
    val timer = new ClockTimer(30)
    
    listenTo(timer)
    reactions += {
        case rt: RedrawTime => clock.repaint
    }
    
    contents = clock
    timer.start()
}

/** The Panel component that draws the clock.
 *  
 *  @param dimension
 *      The area the clock should fit in (with a border)
 */
class ElegantClockPanel(dimension: Dimension) extends BoxPanel(Orientation.Horizontal) {
    var staticItemsPainted = false
    var lastStaticPaintSec = 0.0
    // Minimum dimension will always be height after the window is maximized
    // Figure out the basic measurements of the clock: diameter and border size for X and Y axis
    val yOffset = dimension.getHeight() * 0.1
    val diameter = dimension.getHeight() * 0.8
    val xOffset = (dimension.getWidth() - diameter) / 2
    
    // Create the edge of the clock and the hour and minute ticks
    val outline = new Ellipse2D.Double(xOffset, yOffset, diameter, diameter)
    val origin = (xOffset + diameter/2, yOffset + diameter/2)
    def getCircleTick(percent: Double, origin: (Double, Double), distFromOrigin: Double, diameter: Double) = {
        val (x, y) = Geometry.getPointOnCircle(percent, origin, distFromOrigin)
        new Ellipse2D.Double(x - (diameter/2), y - (diameter/2), diameter, diameter)
    }
    val majorTickWidth = 10
    val minorTickWidth = 2
    val majorTicks = Range(1, 13).map(hr => getCircleTick(hr/12.0, origin, (diameter/2)*0.88, majorTickWidth))
    val minorTicks = Range(1, 61).map(min => getCircleTick(min/60.0, origin, (diameter/2)*0.88, minorTickWidth))
    
    // Instantiate the Stokes used to dra the edge and hands
    background = Color.black
    val outlineStroke = new BasicStroke(10)
    val minHrStroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
    val secStroke = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
    
    override def paintComponent(g: Graphics2D): Unit = {
        // Rendering hints for anti-aliasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC)
        super.paintComponent(g)
        
        g.setColor(Color.LIGHT_GRAY)
        if (!staticItemsPainted) {
            // Draw edge of clock
        	g.setStroke(outlineStroke)
        	g.draw(outline)
        	
        	// Draw ticks
        	majorTicks.map(tick => g.fill(tick))
        	minorTicks.map(tick => g.fill(tick))
            
        	staticItemsPainted = true
        }
        
        // Draw hands
        val (hours, minutes, seconds) = Time.getTime()
        g.setStroke(minHrStroke)
        g.draw( getHand(hours/12, origin, (diameter/2)*0.4) )
        g.draw( getHand(minutes/60, origin, (diameter/2)*0.6472) )
        g.setStroke(secStroke)
        g.draw( getHand(seconds/60, origin, (diameter/2)*0.8) )
        
        if (minutes > lastStaticPaintSec+5) staticItemsPainted = false
    }
    
    /** Get a clock hand (line).
     * 
     *  @param percent
     *  	decimal representing where on the edge of the clock the hand should be pointing
     *   	0 = 12, 0.25 = 3, 0.5 = 6, 0.75 = 9
     *  @param origin
     *  	2-tuple for the center of the clock
     *  @param length
     *  	how long the hand should be
     *  @return A Line2D for the clock hand
     */
    def getHand(percent: Double, origin: (Double, Double), length: Double) = {
        val point = Geometry.getPointOnCircle(percent, origin, length)
        new Line2D.Double(origin._1, origin._2, point._1, point._2)
    }
}

/** Update timer for a clock
 * 
 *  Fires a RedrawTime Event every n milliseconds, where n results in
 *  the desired refresh rate.
 * 
 *  @param fps
 *  	target frames per second (refresh rate)
 */
class ClockTimer(fps: Int) extends Publisher {
    val delay = 1000/fps
    // Custom action to that fires our desired event, so we can use a Swing Timer
    val timeout = new javax.swing.AbstractAction() { def actionPerformed(e: java.awt.event.ActionEvent) = publish(RedrawTime()) }
    val timer = new javax.swing.Timer(delay, timeout)  // Fire "timeout" ever "delay" milliseconds
    timer.setRepeats(true)
    
    def start() = timer.start()
    def stop() = timer.stop()
}

case class RedrawTime() extends Event