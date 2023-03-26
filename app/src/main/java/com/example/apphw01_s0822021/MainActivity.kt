package com.example.apphw01_s0822021

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.jar.Attributes.Name

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //以上都不用改//

        val na1 = findViewById<EditText>(R.id.Name)
        val se1 = findViewById<EditText>(R.id.Sex)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Key1", na1.text.toString())
            bundle.putString("Key2", se1.text.toString())

            val intent =Intent(this,MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivityForResult(intent,1)//step1 發送intent
        }

    }

    //使用onActivityResult()方法來，取得返回資料
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //判斷Intent不能為空，檢查資料是否有數值
        data?.extras?.let {

            if (requestCode == 1 && resultCode == Activity.RESULT_OK)
            {
                //show返回資料
                findViewById<TextView>(R.id.T1).text =
                    "名字: ${it.getString("Key1")}\n\n" +
                    "性別: ${it.getString("Key2")}\n\n" +
                    "尺寸: ${it.getString("Key3")}\n\n" +
                    "顏色: ${it.getString("Key4")}\n\n"
            }
        }
    }
}

