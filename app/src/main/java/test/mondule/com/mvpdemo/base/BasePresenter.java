package test.mondule.com.mvpdemo.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

/**
 * Created by zhaobinsir on 2020/12/19.
 */
public interface BasePresenter{
    //生命周期观察者
    LifecycleObserver getLifeObserver();

    //获取lifecycle
    Lifecycle bindLifeCycle(Lifecycle lifecycle);

}
