package com.example.apphw01_s0822021

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //以上都不用動

        intent?.extras?.let {

            val v1 = it.getString("Key1")
            val textView = findViewById<TextView>(R.id.textView)
            textView.text = v1.toString()
            val v2 = it.getString("Key2")
            val textView2 = findViewById<TextView>(R.id.textView2)
            textView2.text = v2.toString()

            val button2 = findViewById<Button>(R.id.button2)
            button2.setOnClickListener {

                val Si1 = findViewById<EditText>(R.id.Size)
                val Co1 = findViewById<EditText>(R.id.Color)

                val bundle = Bundle()

                bundle.putString("Key1", v1)
                bundle.putString("Key2", v2)


                bundle.putString("Key3", Si1.text.toString())
                bundle.putString("Key4", Co1.text.toString())

                val intent = Intent().putExtras(bundle)
                setResult(RESULT_OK,intent.putExtras(bundle))
                finish()
            }
        }
    }
}