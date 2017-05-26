package net.dudmy.sample_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.dudmy.tutorialpop.TutorialPopHelper

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check current page need tutorial.
        TutorialPopHelper.showTutorialIfNeed(javaClass.simpleName)
    }
}
