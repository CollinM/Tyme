package org.collinm.tyme.utils

import java.util.GregorianCalendar
import java.text.SimpleDateFormat

/** Provides time values with simple functions. */
object Time {
    
	val hourFormat = new SimpleDateFormat("hh")
    val minuteFormat = new SimpleDateFormat("mm")
    val secondFormat = new SimpleDateFormat("ss")
	val millisecondFormat = new SimpleDateFormat("SSS")
	val displayTimeFormat = new SimpleDateFormat("hh:mm:ss")
    
	/** Get the double-valued current time for hours, minutes, seconds, and milliseconds.
	 *  
	 *  The value of hours has its decimal portion populated by the number of 
	 *  minutes, e.g. 5:30 = 5.5.  Similarly, the decimal portion of minutes is
	 *  affected by seconds.  However, this is not true for seconds or 
	 *  milliseconds, each of which will be whole numbers.
     *  
     *  @return 4-tuple of Double's: hours, minutes, seconds, milliseconds
     */
	def getTime(): (Double, Double, Double, Double) = {
	    val time = new GregorianCalendar().getTime()
	    val milliseconds = millisecondFormat.format(time).toDouble
	    val seconds = secondFormat.format(time).toDouble
        val minutes = minuteFormat.format(time).toDouble + seconds/60
        val hours = hourFormat.format(time).toDouble + minutes/60
        (hours, minutes, seconds, milliseconds)
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