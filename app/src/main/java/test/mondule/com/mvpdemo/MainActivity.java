package test.mondule.com.mvpdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import test.mondule.com.mvpdemo.maincontract.LoginContract;
import test.mondule.com.mvpdemo.mainpresenter.LoginPresenterImpl;

public class MainActivity extends AppCompatActivity implements LoginContract.IView {

    private LoginContract.IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
        new LoginPresenterImpl(this);
    }

    @Override
    public void setPresenter(LoginContract.IPresenter presenter) {
        this.presenter= presenter;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isAlive() {
        return !isFinishing();
    }
}