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

package com.bluecat.view404Demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bluecat.view404.View404
import com.bluecat.view404.show404
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.dismissError

class MainActivity : AppCompatActivity() {

    private var view404: View404? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showError.setOnClickListener {
            if (view404 == null) {
                view404 = View404(this, R.layout.layout_404)
                Toast.makeText(this, "shown", Toast.LENGTH_SHORT).show()

                //parentLayout.show404(view404!!)
                errorLayout.show404(view404!!, R.anim.view404_fade_in_default)
            } else {
                Toast.makeText(this, "already shown", Toast.LENGTH_SHORT).show()
            }
        }

        dismissError.setOnClickListener {
            if (view404 != null) {
                Toast.makeText(this, "dismissed", Toast.LENGTH_SHORT).show()

                view404?.dismiss(R.anim.view404_fade_out_default)
                view404 = null
            } else {
                Toast.makeText(this, "already dismissed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
