package net.yslibrary.monotweety.activity

import com.bluelinelabs.conductor.Router
import dagger.Module
import dagger.Provides
import net.yslibrary.monotweety.Navigator
import net.yslibrary.monotweety.base.BaseActivity
import net.yslibrary.monotweety.base.di.ActivityScope
import net.yslibrary.monotweety.base.di.Names
import net.yslibrary.rxeventbus.EventBus
import javax.inject.Named


/**
 * Created by yshrsmz on 2016/09/24.
 */
@Module
class ActivityModule(protected val activity: BaseActivity,
                     protected val router: Router) {

  @Provides
  @Named(Names.FOR_ACTIVITY)
  @ActivityScope
  fun provideActivityBus(): EventBus = EventBus()

  @Provides
  @ActivityScope
  fun provideNavigator(): Navigator {
    return Navigator(activity, router)
  }

  interface Provider {
    @Named(Names.FOR_ACTIVITY)
    fun activityBus(): EventBus

    fun navigator(): Navigator
  }
}