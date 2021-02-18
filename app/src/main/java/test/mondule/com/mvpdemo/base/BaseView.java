package test.mondule.com.mvpdemo.base;

/**
 * Created by zhaobinsir on 2020/12/19.
 */
public interface BaseView<P extends BasePresenter> {
    //绑定监听
    void setPresenter(P presenter);
}
