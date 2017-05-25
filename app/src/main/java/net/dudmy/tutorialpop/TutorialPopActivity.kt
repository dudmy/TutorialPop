package net.dudmy.tutorialpop

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tutorial_pop.*

class TutorialPopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_pop)

        val resId = intent.getIntExtra("resId", 0)
        val drawable = ContextCompat.getDrawable(baseContext, resId)

        iv_tutorial.setImageDrawable(drawable)

        tutor_popup_layout.setOnClickListener{ finish() }
    }
}
