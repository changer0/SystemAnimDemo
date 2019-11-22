package com.lulu.systemanimdemo

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_tween.*
import android.view.animation.Animation.*


/**
 * 补间动画
 */

class TweenActivity : AppCompatActivity() {
    val tag = "TweenActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween)
        //加载 xml 动画资源
        val anim = AnimationUtils.loadAnimation(this, R.anim.tween_anim)
        //设置动画结束后保留结束状态
        anim.fillAfter = true

// 组合动画设置
        val setAnimation = AnimationSet(true)

        // 旋转动画
        val rotate = RotateAnimation(
            0f,
            360f,
            RELATIVE_TO_SELF,
            0.5f,
            RELATIVE_TO_SELF,
            0.5f
        )
        rotate.duration = 3000

        // 平移动画
        val translate = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, -0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_SELF, 0f, TranslateAnimation.RELATIVE_TO_SELF, 0f
        )
        translate.duration = 3000

        // 透明度动画
        val alpha = AlphaAnimation(1f, 0.5f)
        alpha.duration = 3000

        // 缩放动画
        val scale = ScaleAnimation(
            1f,
            0.5f,
            1f,
            0.5f,
            RELATIVE_TO_SELF,
            0.5f,
            RELATIVE_TO_SELF,
            0.5f
        )
        scale.duration = 3000

        // 将创建的子动画添加到组合动画里
        setAnimation.addAnimation(alpha)
        setAnimation.addAnimation(rotate)
        setAnimation.addAnimation(translate)
        setAnimation.addAnimation(scale)
        setAnimation.fillAfter = true

        start.setOnClickListener{
            xmlAnimImg.startAnimation(anim)
            codeAnimImg.startAnimation(setAnimation)


        }

        //设置监听
        setAnimation.setAnimationListener(object : AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
                Log.d(tag,"动画重复时执行" )
            }

            override fun onAnimationEnd(p0: Animation?) {
                Log.d(tag,"动画结束时执行" )
            }

            override fun onAnimationStart(p0: Animation?) {
                Log.d(tag,"动画开始时执行" )
            }

        })

    }

}
