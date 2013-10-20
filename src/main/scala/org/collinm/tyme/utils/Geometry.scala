package org.collinm.tyme.utils

import scala.math.{Pi, cos, sin}

object Geometry {
    
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