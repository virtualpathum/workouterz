package com.lk.infinitx.workouterz.audioplayer


import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

private const val ACTION_PLAY: String = "com.lk.infinitx.workouterz.action.Play"

class AudioService: Service(),MediaPlayer.OnPreparedListener {

    private var mMediaPlayer:MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action: String? = intent?.action

        when(action) {
            "ACTION_PLAY" -> {
                mMediaPlayer = MediaPlayer()
                mMediaPlayer?.apply {
                    setOnPreparedListener(this@AudioService)
                    prepareAsync() // prepare async to not block main thread
                }

            }
        }
        return  super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onPrepared(p0: MediaPlayer?) {
       mMediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayer?.release()
        mMediaPlayer = null
    }
}