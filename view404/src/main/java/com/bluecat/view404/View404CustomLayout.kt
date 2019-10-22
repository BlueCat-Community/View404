package com.bluecat.view404

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view404_customlayout.view.*

class View404CustomLayout private constructor() {

    private lateinit var layoutInflater: LayoutInflater
    private lateinit var customLayout: View

    /** option area */
    var bgColor: Int = R.color.custom_background_default
    var errMsg: String = ""
    var errImg: Int? = null

    /** Static area */
    companion object {
        @SuppressLint("InflateParams")
        @JvmStatic
        fun getInstance(context: Context) = View404CustomLayout().apply {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            customLayout = layoutInflater.inflate(R.layout.view404_customlayout, null).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }

        @JvmStatic
        fun getInstance(
            context: Context,
            bgColor: Int = R.color.custom_background_default,
            errMsg: String = "",
            errImg: Int? = null
        ) = getInstance(context).apply {
            this.bgColor = bgColor
            this.errMsg = errMsg
            this.errImg = errImg
        }
    }


    fun inflate(): View = customLayout.apply {
        setBackgroundColor(bgColor)
        errorText.text = errMsg
        errImg?.let { errorImage.setImageResource(it) }
    }
}