package org.collinm.tyme.faces

import java.awt.Dimension
import scala.swing.BoxPanel
import scala.swing.Orientation
import java.awt.geom.Ellipse2D
import java.awt.geom.Line2D
import java.awt.Color
import java.awt.Graphics2D
import java.awt.BasicStroke
import java.awt.RenderingHints
import org.collinm.tyme.utils.{Time, Geometry, ClockTimer, RedrawTime}
import java.awt.Font

/** Draw a relatively minimalist clock.
 *  
 *  @param dimension
 *      The area the clock should fit in (with a border)
 */
class MinimalClock(dimension: Dimension) extends BoxPanel(Orientation.Horizontal) {
    
    // Minimum dimension will always be height after the window is maximized
    // Figure out the basic measurements of the clock: diameter and border size for X and Y axis
    val yOffset = dimension.getHeight() * 0.05
    val diameter = dimension.getHeight() * 0.9
    val xOffset = (dimension.getWidth() - diameter) / 2
    
    // Create the edge of the clock and the hour and minute ticks
    val outline = new Ellipse2D.Double(xOffset, yOffset, diameter, diameter)
    val origin = (xOffset + diameter/2, yOffset + diameter/2)
    def getLineTick(percent: Double, origin: (Double, Double), distFromOrigin: Double, length: Double) = {
        val (x0, y0) = Geometry.getPointOnCircle(percent, origin, distFromOrigin)
        val (x1, y1) = Geometry.getPointOnCircle(percent, origin, distFromOrigin-length)
        new Line2D.Double(x0, y0, x1, y1)
    }
    val majorTickLength = 10
    val minorTickLength = 4
    val majorTicks = Range(1, 13).map(hr => getLineTick(hr/12.0, origin, (diameter/2)*0.95, majorTickLength))
    val minorTicks = Range(1, 61).map(min => getLineTick(min/60.0, origin, (diameter/2)*0.95, minorTickLength))
    
    // Instantiate strokes
    val ringStroke = new BasicStroke(10)
    val majorTickStroke = new BasicStroke(5)
    val minorTickStroke = new BasicStroke(2)
    val minHrStroke = new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL)
    val secStroke = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL)
    
    // Instantiate Colors
    background = Color.black
    val clockColor = Color.LIGHT_GRAY
    val secondColor = Color.RED
    val textColor = new Color(20, 20, 20)
    
    // Instantiate font
    val timeFont = new Font("SansSerif", Font.PLAIN, (diameter*0.125).toInt)
    
    
    override def paintComponent(g: Graphics2D): Unit = {
        // Rendering hints for anti-aliasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC)
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
        super.paintComponent(g)
        
        // Draw time text
        g.setColor(textColor)
        g.setFont(timeFont)
        val timeStr = Time.getTimeString()
        val timeStrX = xOffset + (diameter*0.5) - (g.getFontMetrics().stringWidth(timeStr) * 0.5)
        g.drawString(timeStr, timeStrX.toFloat, (yOffset+(diameter*0.75)).toFloat)
        
        // Draw date text
        val dateStr = Time.getDateString()
        val dateStrX = xOffset + (diameter*0.5) - (g.getFontMetrics().stringWidth(dateStr) * 0.5)
        g.drawString(dateStr, dateStrX.toFloat, (yOffset+(diameter*0.33)).toFloat)
        
        // Draw hands
        val (hours, minutes, seconds, milliseconds) = Time.getTime()
        // seconds
        g.setColor(secondColor)
        g.setStroke(secStroke)
        g.draw( getHand(seconds/60, origin, (diameter/2)*0.8, 0) )
        // hour, minute
        g.setColor(clockColor)
        g.setStroke(minHrStroke)
        g.draw( getHand(hours/12, origin, diameter*0.2, diameter*0.05) )
        g.draw( getHand(minutes/60, origin, diameter*0.3236, diameter*0.05) )
        
        // repaint clock face
        // Draw edge of clock
    	g.setStroke(ringStroke)
    	g.draw(outline)
    	
    	// Draw ticks
    	g.setStroke(majorTickStroke)
    	majorTicks.map(tick => g.draw(tick))
    	g.setStroke(minorTickStroke)
    	minorTicks.map(tick => g.draw(tick))
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
     *  @param overhang
     *      the length of the hand overhang, the portion on the opposite side of the origin
     *  @return A Line2D for the clock hand
     */
    def getHand(percent: Double, origin: (Double, Double), length: Double, overhang: Double) = {
        val clockPoint = Geometry.getPointOnCircle(percent, origin, length)
        val overPoint = Geometry.getPointOnCircle(percent+0.5, origin, overhang)
        new Line2D.Double(overPoint._1, overPoint._2, clockPoint._1, clockPoint._2)
    }
}