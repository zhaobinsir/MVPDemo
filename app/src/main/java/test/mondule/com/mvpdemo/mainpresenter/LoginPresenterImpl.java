package test.mondule.com.mvpdemo.mainpresenter;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.lang.ref.WeakReference;

import test.mondule.com.mvpdemo.CallBack;
import test.mondule.com.mvpdemo.base.BaseView;
import test.mondule.com.mvpdemo.maincontract.LoginContract;
import test.mondule.com.mvpdemo.mainmodel.LoginModelImpl;

/**
 * Created by zhaobinsir on 2020/12/19.
 */
public class LoginPresenterImpl<V extends BaseView> implements LoginContract.IPresenter {

    private WeakReference<V> viewReference;

    private LoginContract.Model model;

    private LifeController lifeController;

    public LoginPresenterImpl(V view) {
        viewReference = new WeakReference(view);
        view.setPresenter(this);
        model=new LoginModelImpl();
    }

    private LoginContract.IView getIView(){
        return viewReference.get()!=null?(LoginContract.IView)viewReference.get():null;
    }

    @Override
    public void login() {
        //模型层处理
        if (isAlive()) {
            model.loginRequest(new CallBack<String>() {
                @Override
                public void Success(String con) {
                    getIView().showToast(con);
                }

                @Override
                public void Fail(int code) {

                }
            });
        }
    }
    /**
     * 注册观察者
     * */
    @Override
    public LifecycleObserver getLifeObserver() {
        if (lifeController==null) {
            lifeController=new LifeController();
        }
        return lifeController;
    }

    private boolean isAlive(){
        return viewReference.get()!=null&&viewReference.get().isAlive();
    }

    /*public void detachView(){
        if (mView != null) {
            mView.clear();
            mView=null;
        }
    }*/

     class LifeController implements LifecycleObserver {

        private static final String TAG = "LifeController";

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void onCreate() {
            Log.w(TAG, "onCreate: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            Log.w(TAG, "onStart: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            Log.w(TAG, "onResume: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void onPause() {
            Log.w(TAG, "onPause: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop() {
            Log.w(TAG, "onStop: ");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            Log.w(TAG, "onDestroy: ");
        }
    }
}
