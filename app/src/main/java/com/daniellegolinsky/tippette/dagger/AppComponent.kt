package com.daniellegolinsky.tippette.dagger

import com.daniellegolinsky.tippette.TippetteApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ AndroidSupportInjectionModule::class,
                    AppModule::class ]
)
interface AppComponent : AndroidInjector<TippetteApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TippetteApplication): Builder
        fun build(): AppComponent
    }
}