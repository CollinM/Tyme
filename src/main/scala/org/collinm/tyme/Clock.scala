package org.collinm.tyme

import scala.swing.SwingApplication
import scala.swing.MainFrame
import java.awt.Dimension
import scala.swing.Component
import org.collinm.tyme.utils.{ClockTimer, RedrawTime}
import org.collinm.tyme.faces.{MinimalClock, RingClock}


/** Main runtime */
object Clock extends SwingApplication {
    
    def startup(args: Array[String]) = {
        // Parse command line arguments
        val argMap = parseArgs(args)
        val size = (argMap("sizeX").toInt, argMap("sizeY").toInt)
        val refreshRate = argMap("refresh").toInt
        
        // Create Clock
        val frame = new ClockFrame(size._1, size._2, refreshRate, argMap("face"))
        frame.visible = true
    }
    
    /** Parse command line arguments.
     *  
     *  Get the requested size of the window, default = maximize the window.
     *  Get the refresh rate (fps), default = 24
     *  Get the clock face, default = "minimal"
     *  
     * @return Map of arguments
     */
    def parseArgs(args: Array[String]) = {
        def getSize(args: Array[String], vals: Map[String, String]): Map[String, String] = {
            val index = if (args.contains("-s")) args.indexOf("-s")
            			else if (args.contains("--size")) args.indexOf("--size")
            			else -1
            if (index < 0) vals + (("sizeX", "-1"), ("sizeY", "-1"))
            else vals + (("sizeX", args(index+1)), ("sizeY", args(index+2)))
        }
        def getRefresh(args: Array[String], vals: Map[String, String]): Map[String, String] = {
            val index = if (args.contains("-r")) args.indexOf("-r")
            			else if (args.contains("--refresh")) args.indexOf("--refresh")
            			else -1
            if (index < 0) vals + (("refresh", "24"))
            else vals + (("refresh", args(index+1)))
        }
        def getClockFace(args: Array[String], vals: Map[String, String]): Map[String, String] = {
            val index = if (args.contains("-f")) args.indexOf("-f")
            			else if (args.contains("--face")) args.indexOf("--face")
            			else -1
            val face = if (index < 0) "minimal"
            		   else args(index+1)
            vals + (("face", face))
        }
        
        List(getSize _, getRefresh _, getClockFace _).foldLeft(Map[String, String]())((argVals, func) => func(args, argVals))
    }
}

/** The main window frame that houses the clock.
 *  
 *  Creates and owns the clock and it's refresh timer.  Automatically maximizes
 *  itself on creation and instantiates a clock that fits nicely inside the frame
 *  (centered).
 */
class ClockFrame(x: Int, y: Int, refreshRate: Int, face: String) extends MainFrame {
    // Set clock dimensions
    if (x > 0 && y > 0) this.preferredSize = new Dimension(x, y)
    else {
        this.preferredSize = this.toolkit.getScreenSize()
        this.peer.setUndecorated(true)
        this.peer.setAlwaysOnTop(true)
    }

    // Start clock + timer
    val clock: Component = face match {
        case "minimal" => new MinimalClock(this.preferredSize)
        case "ring" => new RingClock(this.preferredSize)
        case _ => new MinimalClock(this.preferredSize)
    }
        
    val timer = new ClockTimer(refreshRate)
    
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