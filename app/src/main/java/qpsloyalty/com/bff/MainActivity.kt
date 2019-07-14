package qpsloyalty.com.bff

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        about.setOnClickListener {
            val intent : Intent = Intent(this@MainActivity,AboutActivity::class.java)
            startActivity(intent)
        }
        profile.setOnClickListener{
            val intent : Intent = Intent(this@MainActivity,ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
