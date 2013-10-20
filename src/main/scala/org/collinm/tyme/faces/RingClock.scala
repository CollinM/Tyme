package org.collinm.tyme.faces

import scala.swing.BoxPanel
import java.awt.Dimension
import scala.swing.Orientation
import java.awt.geom.Ellipse2D
import org.collinm.tyme.utils.Geometry
import java.awt.geom.Line2D
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.RenderingHints
import org.collinm.tyme.utils.Time

class RingClock(dimension: Dimension) extends BoxPanel(Orientation.Horizontal)  {

    // Minimum dimension will always be height after the window is maximized
    // Figure out the basic measurements of the clock
    val yOffset = dimension.getHeight() * 0.1
    val diameter = dimension.getHeight() * 0.8
    val radius = diameter / 2
    val xOffset = (dimension.getWidth() - diameter) / 2
    val origin = (xOffset + radius, yOffset + radius)
    
    // Ring and ticks
    def getLineTick(percent: Double, origin: (Double, Double), distFromOrigin: Double, length: Double) = {
        val (x0, y0) = Geometry.getPointOnCircle(percent, origin, distFromOrigin)
        val (x1, y1) = Geometry.getPointOnCircle(percent, origin, distFromOrigin-length)
        new Line2D.Double(x0, y0, x1, y1)
    }
    val ring = new Ellipse2D.Double(xOffset, yOffset, diameter, diameter)
    val tickLength = 40
    val ticks = Range(0, 12).map(hr => getLineTick(hr/12.0, origin, radius+30, tickLength))
    
    // Strokes
    val ringStroke = new BasicStroke(60)
    val tickStroke = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL)
    
    // Colors
    background = Color.BLACK
    val ringColor = Color.LIGHT_GRAY
    val tickColor = Color.GRAY
    val hourColor = Color.RED
    val minColor = Color.BLACK
    val textColor = new Color(20, 20, 20)
    
    // Instantiate font
    val timeFont = new Font("SansSerif", Font.PLAIN, (diameter*0.125).toInt)
    
    override def paintComponent(g: Graphics2D): Unit = {
        // Rendering hints for anti-aliasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC)
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
        super.paintComponent(g)
        
        // Draw ring
        g.setStroke(ringStroke)
        g.setColor(ringColor)
        g.draw(ring)
        
        // Draw ticks
        g.setStroke(tickStroke)
        g.setColor(tickColor)
        ticks.map(tick => g.draw(tick))
        
        // Draw hands
        val (hours, minutes, seconds, milliseconds) = Time.getTime()
        // hour
        val (xHourPts, yHourPts) = Geometry.getEquilateralTrianglePoints(
                Geometry.getPointOnCircle(hours / 12, origin, radius - 15),
                30.0, 
                (hours / 12) * 360)
        g.setColor(hourColor)
        g.fillPolygon(xHourPts.map(d => d.toInt).toArray, yHourPts.map(d => d.toInt).toArray, 3)
        // minute
        val (xMinPts, yMinPts) = Geometry.getEquilateralTrianglePoints(
                Geometry.getPointOnCircle(minutes / 60, origin, radius - 15),
                30.0, 
                (minutes / 60) * 360)
        g.setColor(minColor)
        g.fillPolygon(xMinPts.map(d => d.toInt).toArray, yMinPts.map(d => d.toInt).toArray, 3)
    }
}