package com.nethergrim.ankobenchmark

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import io.adev.janko.Janko

/**
 * Created by andrej on 17.04.16.
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        Janko.init(this)
    }

}

