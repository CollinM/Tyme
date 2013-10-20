package org.collinm.tyme.utils

import scala.swing.Publisher
import scala.swing.event.Event

/** Update timer for a clock
 * 
 *  Fires a RedrawTime Event every n milliseconds, where n results in
 *  the desired refresh rate.
 * 
 *  @param fps
 *  	target frames per second (refresh rate)
 */
class ClockTimer(fps: Double) extends Publisher {
    val delay = (1000 / fps).toInt
    // Custom action that fires our desired event, so we can use a Swing Timer
    val timeout = new javax.swing.AbstractAction() { def actionPerformed(e: java.awt.event.ActionEvent) = publish(RedrawTime()) }
    val timer = new javax.swing.Timer(delay, timeout)  // Fire "timeout" every "delay" milliseconds
    timer.setRepeats(true)
    
    def start() = timer.start()
    def stop() = timer.stop()
}

case class RedrawTime() extends Event