package net.dudmy.sample_kotlin

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_first.setOnClickListener {
            Intent(this@MainActivity, FirstActivity::class.java).apply { startActivity(this) }
        }

        btn_second.setOnClickListener {
            Intent(this@MainActivity, SecondActivity::class.java).apply { startActivity(this) }
        }

        btn_third.setOnClickListener {
            Intent(this@MainActivity, ThirdActivity::class.java).apply { startActivity(this) }
        }
    }
}
