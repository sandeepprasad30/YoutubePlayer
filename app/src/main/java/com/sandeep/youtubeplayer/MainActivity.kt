package com.sandeep.youtubeplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlaySingle.setOnClickListener (this)
        btnStandAlone.setOnClickListener (this)
    }

    override fun onClick(view: View) {
        Log.d(TAG, "onclick method $view.id")
        val intent = when (view.id) {
            R.id.btnPlaySingle -> Intent(this, YoutubeActivity::class.java)
            R.id.btnStandAlone -> Intent(this, StandaloneActivity::class.java)

            else -> throw IllegalArgumentException("undefined button")
        }

        startActivity(intent)
    }
}
