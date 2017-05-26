package net.dudmy.sample_kotlin

import android.app.Application
import net.dudmy.tutorialpop.TutorialPopHelper

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize for using tutorPopupHelper.
        TutorialPopHelper.prepareTutorial(applicationContext,
                // Create list of class name for show.
                listOf(FirstActivity::class.java.simpleName, SecondActivity::class.java.simpleName))
    }
}
