/*
 * Copyright 2019 Team Mulro in BlueCat-Community
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bluecat.view404

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.core.view.ViewCompat

class View404(context: Context, layout: Int) {

    // NoneNull type
    private var layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    // initialized in show method.
    private lateinit var parentView: RelativeLayout

    // public getter, private setter
    var view404: View
        private set

    // public getter, private setter
    var isShowing = false
        private set

    // initialization
    init {

        // 'apply' refer to the context object as a lambda receiver by keyword 'this',
        //  it returns context object.
        view404 = layoutInflater.inflate(layout, null).apply {
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    fun show(parentView: RelativeLayout?) {
        if (!isShowing && parentView != null) {
            this.parentView = parentView

            // 'run' refer to the context object as a lambda receiver by keyword 'this',
            //  it returns the lambda result.
            this.parentView.run {
                addView(view404, 0)
                bringToFront()
                requestLayout()
                invalidate()
            }
            ViewCompat.setTranslationZ(view404, 99f)
            isShowing = true
        }
    }

    fun dismiss() {
        if (isShowing) {
            parentView.removeView(view404)
        }
    }
}