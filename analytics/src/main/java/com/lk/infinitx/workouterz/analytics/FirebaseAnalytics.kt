package com.lk.infinitx.workouterz.analytics

import android.app.Application
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseAnalytics(application: Application) :Analytics {

    private val firebaseAnalytics:FirebaseAnalytics = FirebaseAnalytics.getInstance(application)

    override fun logEvent(event: String, screen: String) {
        var bundle = Bundle()
        bundle.putString("event",event)
        bundle.putString("screen",screen)
        firebaseAnalytics.logEvent("event",bundle)
    }
}