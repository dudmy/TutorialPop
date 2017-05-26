package net.dudmy.sample_java;

import android.app.Application;

import net.dudmy.tutorialpop.TutorialPopHelper;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Create list of class name for show.
        List<String> tutorList = new ArrayList<>();
        tutorList.add(FirstActivity.class.getSimpleName());
        tutorList.add(SecondActivity.class.getSimpleName());

        // Initialize for using tutorPopupHelper.
        TutorialPopHelper.INSTANCE.prepareTutorial(getApplicationContext(), tutorList);
    }
}
