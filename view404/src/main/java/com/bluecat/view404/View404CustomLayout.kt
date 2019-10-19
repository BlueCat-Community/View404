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
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class View404CustomLayout(context: Context, errMsg: String?, errImg: Drawable?) {
    private val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    var customLayout: View
        private set

    init {
        customLayout = layoutInflater.inflate(R.layout.view404_customlayout, null).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        if (errMsg != null) {
            val customMsg: TextView = customLayout.findViewById(R.id.errorText)
            customMsg.text = errMsg
        }

        if (errImg != null) {
            val customImg: ImageView = customLayout.findViewById(R.id.errorImage)
            customImg.setImageDrawable(errImg)
        }
    }

    fun make(): View {
        return customLayout
    }
}
