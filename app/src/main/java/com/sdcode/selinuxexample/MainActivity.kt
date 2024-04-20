package com.sdcode.selinuxexample

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileWriter
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {
            triggerAVCDenial()
        })
    }

    private fun triggerAVCDenial() {
        val file = File("/sys/class/leds/flashlight/brightness")
        try {
            val writer = FileWriter(file)
            writer.write("1")
            writer.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}