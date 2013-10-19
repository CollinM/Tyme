package org.collinm.tyme.utils

import java.util.GregorianCalendar
import java.text.SimpleDateFormat

object Time {
	val hourFormat = new SimpleDateFormat("hh")
    val minuteFormat = new SimpleDateFormat("mm")
    val secondFormat = new SimpleDateFormat("ss.SSS")
	val displayTimeFormat = new SimpleDateFormat("hh:mm:ss")
    
	/** Get the double-valued current time for hours, minutes, and seconds.
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
	
	/** Get the String of the current time.
	 * 
	 * @return String of the current time in the format "hh:mm:ss"
	 */
	def getTimeString(): String = {
	    val time = new GregorianCalendar().getTime()
	    displayTimeFormat.format(time)
	}
}