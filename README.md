# 404View
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)

🍀 Easy way to implement 404 screens for android.

<img src="https://user-images.githubusercontent.com/3215313/66920434-3ba87a80-f05e-11e9-81a1-38fa12b211be.gif" width="40%">


## Including in your project
[![Version](https://img.shields.io/github/v/release/BlueCat-Community/View404)](https://github.com/BlueCat-Community/View404/releases)
[![](https://jitpack.io/v/BlueCat-Community/View404.svg)](https://jitpack.io/#BlueCat-Community/View404)

### Gradle
Add Below codes to your root `build.gradle` file! (Not your module's build.gradle file).
```
allprojects {
    repositories {
        maven {
            url 'https://jitpack.io'
        }
    }
}
```
And add a dependency code to your module's `build.gradle` file.
```
dependencies {
    implementation 'com.github.BlueCat-Community:View404:v1.0.0'
}
```

## Usage
Make Layout XML File for Showing Error inside your project's res/layout.
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/white">

    <TextView
        android:id="@+id/text_404"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:text="There is no results!"
        android:textSize="16sp"
        android:textStyle="bold" />

</RelativeLayout>
```

..And Add Error Layout Space in Your Layout.
```xml
<RelativeLayout
    android:id="@+id/errorLayout"
    android:background="#000000"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="50dp" />
```

Import following Package inside your Class.
```kotlin
import com.bluecat.view404.View404
import com.bluecat.view404.show404
```

Make Variable for View404.
```kotlin
private var view404: View404? = null
```

If you want to overlay 'not found' View on your ViewGroup, 
```kotlin
if(view404 == null)
    view404 = View404(this, R.layout.layout_404)
    errorLayout.show404(view404!!, R.anim.view404_fade_in_default)
}
```

If you want to dismiss 'not found' View on your ViewGroup, 
```kotlin
if(view404 != null) {
    view404?.dismiss(R.anim.view404_fade_out_default)
    view404 = null
}
```
# License
```
 Copyright 2019 Team Mulro in BlueCat-Community

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