package org.collinm.tyme

import scala.swing.SwingApplication
import scala.swing.MainFrame
import java.awt.Dimension
import org.collinm.tyme.utils.{ClockTimer, RedrawTime}
import org.collinm.tyme.faces.MinimalClock

/** Main runtime */
object Clock extends SwingApplication {
    
    def startup(args: Array[String]) = {
        // Parse command line arguments
        val argMap = parseArgs(args)
        val size = if (argMap.contains("sizeX")) (argMap("sizeX").toInt, argMap("sizeY").toInt)
        		   else (-1, -1)
        
        // Create Clock
        val frame = new ClockFrame(size._1, size._2)
        frame.visible = true
    }
    
    /** Parse command line arguments.
     *  
     * @return Map of arguments
     */
    def parseArgs(args: Array[String]) = {
        def getSize(args: Array[String], vals: Map[String, String]): Map[String, String] = {
            val index = if (args.contains("-s")) args.indexOf("-s")
            			else if (args.contains("--size")) args.indexOf("--size")
            			else -1
            if (index < 0) vals
            else vals + (("sizeX", args(index+1)), ("sizeY", args(index+2)))
        }
        
        getSize(args, Map[String,String]())
    }
}

/** The main window frame that houses the clock.
 *  
 *  Creates and owns the clock and it's refresh timer.  Automatically maximizes
 *  itself on creation and instantiates a clock that fits nicely inside the frame
 *  (centered).
 */
class ClockFrame(x: Int, y: Int) extends MainFrame {
    if (x > 0 && y > 0) this.preferredSize = new Dimension(x, y)
    else {
        this.preferredSize = this.toolkit.getScreenSize()
        this.peer.setUndecorated(true)
        this.peer.setAlwaysOnTop(true)
    }
    
    val clock = new MinimalClock(this.preferredSize)
    val timer = new ClockTimer(30)
    
    listenTo(timer)
    reactions += {
        case rt: RedrawTime => clock.repaint
    }
    
    contents = clock
    timer.start()
    
    /** Last method to be called upon exit */
    override def closeOperation(): Unit = {
        timer.stop()
        this.dispose()
        sys.exit(0)
    }
}