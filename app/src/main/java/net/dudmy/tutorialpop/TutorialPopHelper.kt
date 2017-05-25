package net.dudmy.tutorialpop

import android.content.Context
import android.content.Intent
import android.preference.PreferenceManager

object TutorialPopHelper {

    /* Prefix for preferences key */
    private val PREFIX: String = "tutorial_"

    private lateinit var context: Context

    /* A map holding tutorial screen and flag information */
    private var tutorialMap: MutableMap<String, Boolean> = HashMap()

    /**
     * Prepare helper before using it.
     *
     * @param context Context
     * @param classNameList List of class name you want to show tutorial
     */
    fun prepareTutorial(context: Context, classNameList: List<String>) {
        this.context = context

        classNameList.forEach { load(PREFIX + it.toLowerCase()) }
    }

    /**
     * Check if the current screen should show the tutorial.
     * If necessary, go to the tutorial popup view.
     *
     * @param className Name of current visible screen's class
     */
    fun showTutorialIfNeed(className: String) {
        val prefKey = PREFIX + className.toLowerCase()

        if (tutorialMap[prefKey] ?: true) {
            // There are no tutorials to show on the screen, or
            // user have already seen them.
            return
        }

        context.let {
            val resId = it.resources.getIdentifier(prefKey, "drawable", it.packageName)

            if (resId == 0) {
                // Not a valid resource ID.
                return
            }

            save(prefKey)

            // Go to popup view for showing.
            val intent = Intent(it, TutorialPopActivity::class.java)
            intent.putExtra("resId", resId)
            it.startActivity(intent)
        }
    }

    /**
     * Load tutorial flag from preferences.
     */
    private fun load(prefKey: String) {
        PreferenceManager.getDefaultSharedPreferences(context).run {
            tutorialMap.put(prefKey, getBoolean(prefKey, false))
        }
    }

    /**
     * Save tutorial flag to preferences.
     */
    private fun save(prefKey: String) {
        tutorialMap.put(prefKey, true)

        PreferenceManager.getDefaultSharedPreferences(context).edit().run {
            putBoolean(prefKey, true)
            commit()
        }
    }
}