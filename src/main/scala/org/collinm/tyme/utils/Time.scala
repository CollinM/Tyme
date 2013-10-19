package org.collinm.tyme.utils

import java.util.GregorianCalendar
import java.text.SimpleDateFormat

/** Provides time values with simple functions. */
object Time {
    
	val hourFmt = new SimpleDateFormat("hh")
    val minuteFmt = new SimpleDateFormat("mm")
    val secondFmt = new SimpleDateFormat("ss")
	val millisecondFmt = new SimpleDateFormat("SSS")
	val displayTimeFmt = new SimpleDateFormat("hh:mm:ss")
	val displayDateFmt = new SimpleDateFormat("MM/dd")
    
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
	    val milliseconds = millisecondFmt.format(time).toDouble
	    val seconds = secondFmt.format(time).toDouble
        val minutes = minuteFmt.format(time).toDouble + seconds/60
        val hours = hourFmt.format(time).toDouble + minutes/60
        (hours, minutes, seconds, milliseconds)
	}
	
	/** Get the String of the current time.
	 * 
	 * @return String of the current time in the format "hh:mm:ss"
	 */
	def getTimeString(): String = {
	    val time = new GregorianCalendar().getTime()
	    displayTimeFmt.format(time)
	}
	
	/** Get the String of the current date.
	 * 
	 * @return String of the current date in the format "mm/dd"
	 */
	def getDateString(): String = {
	    val time = new GregorianCalendar().getTime()
	    displayDateFmt.format(time)
	}
}