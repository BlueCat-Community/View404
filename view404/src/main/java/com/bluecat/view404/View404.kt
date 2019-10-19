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
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.view.ViewCompat

class View404(private val context: Context, layout: Any?) {

    /** NoneNull type */
    private var layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    /** initialized in show method. */
    private var parentView: ViewGroup? = null

    /** public getter, private setter */
    var view404: View? = null
        private set

    /** public getter, private setter */
    var isShowing = false
        private set

    /** initialization */
    init {
        /** 'apply' refer to the context object as a lambda receiver by keyword 'this',
        it returns context object. */
        if(layout is Int) {
            view404 = layoutInflater.inflate(layout, null).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }
        else if(layout is View) {
            view404 = layout
        }
        else {
            view404 = null
        }
    }

    /** shows the view404 on the parent view.
        if you want to put another fadeIn animation, you can do that. */
    fun show(parentView: ViewGroup?, fadeInAnimation:Int = R.anim.not_move_activity) {
        if (!isShowing && parentView != null) {
            this.parentView = parentView
            view404!!.startAnimation(AnimationUtils.loadAnimation(context, fadeInAnimation))
            /** 'run' refer to the context object as a lambda receiver by keyword 'this',
            it returns the lambda result. */
            this.parentView?.run {
                addView(view404, 0)
                bringToFront()
                requestLayout()
                invalidate()
            }

            ViewCompat.setTranslationZ(view404!!, 99f)
            isShowing = true
        }
    }

    /** dismiss the view404 on the parent view.
        if you want to put another fadeOut animation, you can do that. */
    fun dismiss(fadeOutAnimation:Int = R.anim.not_move_activity) {
        if (isShowing) {
            view404!!.startAnimation(AnimationUtils.loadAnimation(context, fadeOutAnimation))
            parentView?.removeView(view404)
            isShowing = false
        }
    }
}
