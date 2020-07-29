package com.daniellegolinsky.tippette

import com.daniellegolinsky.tippette.dagger.AppComponent
import com.daniellegolinsky.tippette.dagger.DaggerAppComponent
import com.daniellegolinsky.tippette.dagger.ResourceProvider
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TippetteApplication: DaggerApplication() {

    companion object {
        lateinit var component: AppComponent
        lateinit var resourceProvider: ResourceProvider
    }

    override fun onCreate() {
        super.onCreate()
        resourceProvider = ResourceProvider(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent.builder().application(this).build()
        return component
    }
}