package com.sun.baseapp.ui.login;


import android.widget.Toast;

import com.sun.baseapp.R;
import com.sun.baseapp.base.BaseActivity;
import com.sun.baseapp.ui.UIUtils;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {

    @Inject
    LoginPresenter presenter;

    LoginFragment loginFragment = null;
    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

         loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrameLayout);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            UIUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.contentFrameLayout);
        }
        loginFragment.setPresenter(presenter);

    }

    @Override
    public void loginSuccess(LoginContract.Model result) {
        loginFragment.loginSuccess(result);
//        Toast.makeText(this, "result.getMsg()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
    }
}
