package test.mondule.com.mvpdemo;

/**
 * Created by zhaobinsir on 2020/12/19.
 */
public interface CallBack<T> {
    void Success(T t);
    void Fail(int code);
}
