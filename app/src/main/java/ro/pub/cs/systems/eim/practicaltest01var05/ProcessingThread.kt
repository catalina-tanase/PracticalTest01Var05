import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class ProcessingThread(private val context: Context, private val template: String) : Thread() {

    private var isRunning = true
    private val elements = template.split(",")
    private var index = 0

    override fun run() {
        Log.d("ProcessingThread", "Thread has started! PID: ${android.os.Process.myPid()} TID: ${android.os.Process.myTid()}")
        while (isRunning && index < elements.size) {
            sendMessage(elements[index])
            sleep()
            index++
        }
        Log.d("ProcessingThread", "Thread has stopped!")
    }

    private fun sendMessage(message: String) {
        val intent = Intent("com.example.ACTION_SEND_MESSAGE")
        intent.putExtra("MESSAGE", message)
        Log.d("ProcessingThread", "Sending broadcast: ${intent.action} with data: $message")
        context.sendBroadcast(intent)
    }

    private fun sleep() {
        try {
            Thread.sleep(5000)
        } catch (interruptedException: InterruptedException) {
            interruptedException.printStackTrace()
        }
    }

    fun stopThread() {
        isRunning = false
    }
}
