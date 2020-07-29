package com.daniellegolinsky.tippette.dagger

import com.daniellegolinsky.tippette.TippetteApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun providesResourceProvider(): ResourceProvider {
        return TippetteApplication.resourceProvider
    }
}