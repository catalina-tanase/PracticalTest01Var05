package ro.pub.cs.systems.eim.practicaltest01var05

import ProcessingThread
import android.app.Service
import android.content.Intent
import android.os.IBinder

class PracticalTest01Var05Service : Service() {

        private lateinit var processingThread: ProcessingThread

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            val template = intent?.getStringExtra("TEMPLATE")
            template?.let {
                processingThread = ProcessingThread(this, it)
                processingThread.start()
            }
            return START_STICKY
        }

        override fun onDestroy() {
            processingThread.stopThread()
            super.onDestroy()
        }

        override fun onBind(intent: Intent?): IBinder? {
            return null
        }

}