package com.sandeep.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*
import java.lang.IllegalArgumentException

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

        btnPlayVideo.setOnClickListener(this)
        btnPlaylist.setOnClickListener(this)

        /*btnPlayVideo.setOnClickListener  (object: View.OnClickListener{
            override fun onClick(p0: View?) {
            }
        })*/

        /*btnPlayVideo.setOnClickListener ( View.OnClickListener { v ->
        })*/

        /*val listener = View.OnClickListener { v ->
        }*/

        // btnPlaylist.setOnClickListener { listener }
    }

    override fun onClick(view: View) {
        val intent = when (view.id) {
            R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID, 0, true, false)

            R.id.btnPlaylist -> YouTubeStandalonePlayer.createPlaylistIntent(this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_PLAYLIST, 0, 0, true, true)

            else -> throw IllegalArgumentException("undefined button")
        }

        startActivity(intent)
    }
}