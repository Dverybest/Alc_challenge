package qpsloyalty.com.bff

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_splash.*
import android.animation.Animator
import android.support.v4.view.ViewCompat.animate
import android.R.attr.rotation
import android.support.v4.view.ViewCompat.setTranslationX
import android.support.v4.view.ViewCompat.setTranslationY
import android.widget.TextView


class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        textView.translationY = 1000f
        textView.translationX =1000f

        textView
            .animate()
            .translationXBy(-1000f)
            .translationYBy(-1000f)
            .rotation(1800f)
            .setDuration(2000)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {

                }

                override fun onAnimationEnd(animation: Animator) {
                    Handler().postDelayed({
                        startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                        finish()
                    },SPLASH_TIME_OUT)

                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationRepeat(animation: Animator) {

                }
            })



    }


}
