package com.lk.infinitx.workouterz.presentation.di

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import com.lk.infinitx.workouterz.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
class MediaModule {

    @Provides
    @Singleton
    fun providesMediaPlayer(@ApplicationContext context:Context):MediaPlayer{
        val sound = Uri.parse("android.resource://com.lk.infinitx.workouterz/" + R.raw.press_start)
        return MediaPlayer.create(context,sound).apply {
            isLooping = false
        }
    }
}