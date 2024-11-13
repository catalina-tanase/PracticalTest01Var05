package ro.pub.cs.systems.eim.practicaltest01var05

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var05SecondaryActivity : AppCompatActivity() {
    private lateinit var editTextTemplate: EditText
    private lateinit var buttonVerify: Button
    private lateinit var buttonCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var05_secondary)
        editTextTemplate = findViewById(R.id.edit_text_template)
        buttonVerify = findViewById(R.id.button_verify)
        buttonCancel = findViewById(R.id.button_cancel)

        val template = intent.getStringExtra("TEMPLATE")
        editTextTemplate.setText(template)
        buttonVerify.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("RESULT", "Verified")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
        buttonCancel.setOnClickListener { val resultIntent = Intent()
            resultIntent.putExtra("RESULT", "Cancelled")
            setResult(Activity.RESULT_CANCELED, resultIntent)
            finish()
        }
    }

}