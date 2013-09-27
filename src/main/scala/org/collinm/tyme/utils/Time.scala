package org.collinm.tyme.utils

import java.util.GregorianCalendar
import java.text.SimpleDateFormat

object Time {
	val hourFormat = new SimpleDateFormat("hh")
    val minuteFormat = new SimpleDateFormat("mm")
    val secondFormat = new SimpleDateFormat("ss.SSS")
    
	/** Get the double-valued time for hours, minutes, and seconds.
     *  
     *  @return 3-tuple of Double's: hours, minutes, seconds
     */
	def getTime(): (Double, Double, Double) = {
	    val time = new GregorianCalendar().getTime()
	    val seconds = secondFormat.format(time).toDouble
        val minutes = minuteFormat.format(time).toDouble + seconds/60
        val hours = hourFormat.format(time).toDouble + minutes/60
        (hours, minutes, seconds)
	}
}