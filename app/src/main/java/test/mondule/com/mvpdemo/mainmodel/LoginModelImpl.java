package test.mondule.com.mvpdemo.mainmodel;

import test.mondule.com.mvpdemo.CallBack;
import test.mondule.com.mvpdemo.maincontract.LoginContract;

/**
 * Created by zhaobinsir on 2020/12/19.
 */
public class LoginModelImpl implements LoginContract.Model {

    @Override
    public void loginRequest(CallBack<String> callBack) {
        callBack.Success("登录成功");
    }
}
