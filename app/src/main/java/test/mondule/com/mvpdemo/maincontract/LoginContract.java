package test.mondule.com.mvpdemo.maincontract;

import androidx.lifecycle.LifecycleObserver;

import test.mondule.com.mvpdemo.CallBack;
import test.mondule.com.mvpdemo.base.BaseModel;
import test.mondule.com.mvpdemo.base.BasePresenter;
import test.mondule.com.mvpdemo.base.BaseView;

/**
 * Created by zhaobinsir on 2020/12/19.
 */
public interface LoginContract {
    
    interface Model extends BaseModel{
        void loginRequest(CallBack<String> callBack);
    }

    interface IView extends BaseView<IPresenter> {
        void showToast(String msg);
    }

    interface IPresenter extends BasePresenter {

        void login();
        //生命周期观察者
        LifecycleObserver getLifeObserver();
    }
}
