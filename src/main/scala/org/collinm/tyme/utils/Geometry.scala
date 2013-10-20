package org.collinm.tyme.utils

import scala.math.{Pi, cos, sin}

object Geometry {
    
    /** Calculates a point in space on an imaginary circle.
     *  
     *  @param percent
     *  	how far around the circle the point is, e.g. 0% = 12 o'clock, 25% = 3 o'clock
     *  @param origin
     *  	the origin of the circle
     *  @param radius
     *  	the radius of the circle
     *   
     *  @return an (x,y) point tuple of Double's
     */
	def getPointOnCircle(percent: Double, origin: (Double, Double), radius: Double): (Double, Double) = {
	    val radians = (percent * 2*Pi) - Pi/2
	    (origin._1 + (radius * cos(radians)), origin._2 + radius * sin(radians))
	}
	
	/**
	 * @param origin
	 * 		origin of the circle that the triangle will be drawn in
	 * @param radius
	 *  	radius of the circle that the triangle will be drawn in
	 * @param rotate
	 * 		degrees to rotate the triangle (clockwise)
	 */
	def getEquilateralTrianglePoints(origin: (Double, Double), radius: Double, rotate: Double): (List[Double], List[Double]) = {
	    val top = getPointOnCircle(rotate / 360, origin, radius)
	    val right = getPointOnCircle((120 + rotate) / 360, origin, radius)
	    val left = getPointOnCircle((240 + rotate) / 360, origin, radius)
	    List(top, right, left).unzip[Double, Double]
	}
}