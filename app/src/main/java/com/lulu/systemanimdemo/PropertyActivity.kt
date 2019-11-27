package com.lulu.systemanimdemo

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_property.*

class PropertyActivity : AppCompatActivity() {

    private val tag = "PropertyActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property)

        val colorAnim = ValueAnimator.ofInt(Color.RED, Color.BLUE)
        colorAnim.duration = 5000
        colorAnim.setEvaluator(ArgbEvaluator())
        colorAnim.addUpdateListener {
            Log.d(tag, it.animatedValue.toString())
            xmlAnimTarget.setBackgroundColor(it.animatedValue as Int)
        }
        start.setOnClickListener{
            colorAnim.start()
        }
    }
}
