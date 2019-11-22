package com.lulu.systemanimdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        frameAnim.setOnClickListener {
            startActivity(Intent(this@MainActivity, FrameActivity::class.java))
        }
        tweenAnim.setOnClickListener {
            startActivity(Intent(this@MainActivity, TweenActivity::class.java))
        }
    }
}
