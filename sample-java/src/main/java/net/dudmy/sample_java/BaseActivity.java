package net.dudmy.sample_java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.dudmy.tutorialpop.TutorialPopHelper;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check current page need tutorial.
        TutorialPopHelper.INSTANCE.showTutorialIfNeed(getClass().getSimpleName());
    }
}
