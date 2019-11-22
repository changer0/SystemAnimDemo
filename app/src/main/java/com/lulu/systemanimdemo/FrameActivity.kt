package com.lulu.systemanimdemo

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lulu.systemanimdemo.test.Utils
import kotlinx.android.synthetic.main.activity_frame.*

class FrameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        //xml 实现动画 使用 as 进行强转
        val xmlAnimDrawable = xmlAnimImg.background as? AnimationDrawable

        //代码实现
        val animationDrawable = AnimationDrawable()
        animationDrawable.isOneShot = false
        //0<=i<=100
        for (i in 1 .. 8) {
            val animDrawable = resources.getDrawable(Utils.getResIdByString("leopard$i", R.drawable::class.java))
            animationDrawable.addFrame(animDrawable, 100)
        }
        codeAnimImg.setImageDrawable(animationDrawable)
        start.setOnClickListener {
            animationDrawable.start()
            xmlAnimDrawable?.start()
        }
        stop.setOnClickListener{
            animationDrawable.stop()
            xmlAnimDrawable?.stop()
        }

    }
}
