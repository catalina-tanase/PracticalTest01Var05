package ro.pub.cs.systems.eim.practicaltest01var05

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var05MainActivity : AppCompatActivity() {
    private lateinit var editTextField: EditText
    private lateinit var buttonTopLeft: Button
    private lateinit var buttonTopRight: Button
    private lateinit var buttonCenter: Button
    private lateinit var buttonBottomLeft: Button
    private lateinit var buttonBottomRight: Button
    private lateinit var buttonTransfer: Button

    private var clickCount: Int = 0

    private val buttonClickListener = ButtonClickListener()
    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            clickCount++
            when (view.id) {
                R.id.button_top_left -> appendText("Top Left")
                R.id.button_top_right -> appendText("Top Right")
                R.id.button_center -> appendText("Center")
                R.id.button_bottom_left -> appendText("Bottom Left")
                R.id.button_bottom_right -> appendText("Bottom Right")
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var05_main)
        editTextField = findViewById(R.id.text_field)
        buttonTopLeft = findViewById(R.id.button_top_left)
        buttonTopRight = findViewById(R.id.button_top_right)
        buttonCenter = findViewById(R.id.button_center)
        buttonBottomLeft = findViewById(R.id.button_bottom_left)
        buttonBottomRight = findViewById(R.id.button_bottom_right)
        buttonTransfer = findViewById(R.id.button_transfer)


        buttonTopLeft.setOnClickListener(buttonClickListener)
        buttonTopRight.setOnClickListener(buttonClickListener)
        buttonCenter.setOnClickListener(buttonClickListener)
        buttonBottomLeft.setOnClickListener(buttonClickListener)
        buttonBottomRight.setOnClickListener(buttonClickListener)

        if (savedInstanceState != null) {
            clickCount = savedInstanceState.getInt("click_count", 0)
            Toast.makeText(this, "Total Clicks: $clickCount", Toast.LENGTH_SHORT).show()
        }

    }
    private fun appendText(text: String) {
        val currentText = editTextField.text.toString()
        val newText = if (currentText.isEmpty()) text else "$currentText, $text"
        editTextField.setText(newText)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("click_count", clickCount)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        clickCount = savedInstanceState.getInt("click_count", 0)
        Toast.makeText(this, "Total Clicks: $clickCount", Toast.LENGTH_SHORT).show()
    }
}