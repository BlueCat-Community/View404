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
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import androidx.core.view.ViewCompat

class View404 {

    private val context: Context
    /** NoneNull type */
    private var layoutInflater: LayoutInflater

    /** initialization(Layout Resource ID)*/
    constructor(context: Context, @LayoutRes layout: Int) {
        this.context = context
        layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        /** 'apply' refer to the context object as a lambda receiver by keyword 'this',
        it returns context object. */
        view404 = layoutInflater.inflate(layout, null).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
    }

    /** initialization(Custom View) */
    constructor(context: Context, layout: View) {
        this.context = context
        layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view404 = layout
    }


    /** initialized in show method. */
    private var parentView: ViewGroup? = null

    /** public getter, private setter */
    var view404: View? = null
        private set

    /** public getter, private setter */
    var isShowing = false
        private set

    /** shows the view404 on the parent view.
    if you want to put another fadeIn animation, you can do that. */
    fun show(parentView: ViewGroup?, fadeInAnimation: Int = R.anim.not_move_activity) {
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
    fun dismiss(fadeOutAnimation: Int = R.anim.not_move_activity) {
        if (isShowing) {
            view404!!.startAnimation(AnimationUtils.loadAnimation(context, fadeOutAnimation))
            parentView?.removeView(view404)
            isShowing = false
        }
    }
}
