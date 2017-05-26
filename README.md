# TutorialPop

[![license](https://img.shields.io/hexpm/l/plug.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![download](https://img.shields.io/badge/download-1.0.0-green.svg)](https://bintray.com/dudmy/maven/tutorialpop)

Helps you easily view tutorial popup. You only need to know the drawable and the class name of the screen you want to show. There is no need to consider anything else.

## How to use

### Add to dependencies

```groovy
dependiencies {
    compile 'net.dudmy:tutorialpop:1.0.0'
}
```

### Base with java

First, you must prepare in the Application class. Pass a context and list of the class names of the screens to show the tutorial as parameters.

```java
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        List<String> tutorList = new ArrayList<>();
        tutorList.add(FirstActivity.class.getSimpleName());
        tutorList.add(SecondActivity.class.getSimpleName());

        TutorialPopHelper.INSTANCE.prepareTutorial(getApplicationContext(), tutorList);
    }
}
```

and then check out the current page needed tutorial in the Base Activity class.

```java
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TutorialPopHelper.INSTANCE.showTutorialIfNeed(getClass().getSimpleName());
    }
}
```

### Base with kotlin

First, you must prepare in the Application class. Pass a context and list of the class names of the screens to show the tutorial as parameters.

```kotlin
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        TutorialPopHelper.prepareTutorial(applicationContext,
                listOf(FirstActivity::class.java.simpleName, SecondActivity::class.java.simpleName))
    }
}
```

and then check out the current page needed tutorial in the Base Activity class.

```kotlin
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TutorialPopHelper.showTutorialIfNeed(javaClass.simpleName)
    }
}
```

**IMPORTANT!! Drawable's name must like 'tutorial_{ClassNameWithLowerCase}'.**  
If the page name you need to show the tutorial is FirstActivity and SecondActivity,  
drawable name is tutorial_firstactivity and tutorial_secondactivity.

## Used library version

* Kotlin version: 1.1.2-3
* Support library version: 25.3.1

## License

```
Copyright 2017 Yujin Jung

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
