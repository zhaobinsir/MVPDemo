package test.mondule.com.mvpdemo.mainpresenter;

import java.lang.ref.WeakReference;

import test.mondule.com.mvpdemo.CallBack;
import test.mondule.com.mvpdemo.base.BaseView;
import test.mondule.com.mvpdemo.maincontract.LoginContract;
import test.mondule.com.mvpdemo.mainmodel.LoginModelImpl;

/**
 * Created by zhaobinsir on 2020/12/19.
 */
public class LoginPresenterImpl<V extends BaseView> implements LoginContract.IPresenter {

    private WeakReference<V> mView;

    private LoginContract.Model model;

    public LoginPresenterImpl(V view) {
        this.mView = new WeakReference(view);
        view.setPresenter(this);
        model=new LoginModelImpl();
    }

    @Override
    public void login() {
        //模型层处理
        if (isAlive()) {
            model.loginRequest(new CallBack<String>() {
                @Override
                public void Success(String con) {
                    ((LoginContract.IView)mView.get()).showToast(con);
                }

                @Override
                public void Fail(int code) {

                }
            });
        }
    }

    private boolean isAlive(){
        return mView!=null&&mView.get().isAlive();
    }

    /*public void detachView(){
        if (mView != null) {
            mView.clear();
            mView=null;
        }
    }*/
}
