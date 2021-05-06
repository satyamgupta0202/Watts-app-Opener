package com.example.wattsappopener

import android.app.Notification
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import java.lang.reflect.Array.getChar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num: String ="0"

        if(intent.action == Intent.ACTION_PROCESS_TEXT){
            num = intent.getCharSequenceArrayExtra(Intent.EXTRA_PROCESS_TEXT).toString()
        }
        if(num.isDigitsOnly()){
            openWattsapp(num)
        }
        else{
            Toast.makeText(this,"Enter digits only",Toast.LENGTH_SHORT).show()
        }
    }

    private fun openWattsapp(num: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setPackage("com.whatsapp")

          val data:String =   if(num[0]=='+'){
                num.substring(1)
            }
         else if(num.length== 10){
            "91"+num
           }
          else{
            num
           }


    }
}