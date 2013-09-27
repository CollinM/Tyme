package org.collinm.tyme.utils

import scala.math.{Pi, cos, sin}

object Geometry {
    
	def getPointOnCircle(percent: Double, origin: (Double, Double), radius: Double): (Double, Double) = {
	    val radians = (percent * 2*Pi) - Pi/2
	    (origin._1 + (radius * cos(radians)), origin._2 + radius * sin(radians))
	}
}