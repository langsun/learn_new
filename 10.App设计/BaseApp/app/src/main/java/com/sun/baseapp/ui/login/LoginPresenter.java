package com.sun.baseapp.ui.login;

import android.util.Log;

import com.sun.baseapp.base.AbsPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * presenter层负责逻辑功能代码、调用网络数据、本地数据封装层的编写
 */
public class LoginPresenter extends AbsPresenter<LoginContract.Model,LoginContract.View> implements LoginContract.Presenter {

    private Disposable disposable;


    @Inject
    public LoginPresenter(LoginModel model,LoginActivity view) {
        mModel = model;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void login(String mobile, String password) {

        //通过Model获取数据
        disposable = mModel.login(mobile, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //然后去更新View层的UI
                .subscribe(mView::loginSuccess,s -> System.out.println(s.getMessage()));
//                .subscribe(new Consumer<LoginContract.Model>() {
//                    @Override
//                    public void accept(LoginContract.Model model) throws Exception {
//                        if (model.isSucess()) {
//                            mView.loginSuccess(model);
//                        } else {
//                            Log.e("aaa", model.getMsg());
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        throwable.getMessage();
//                    }
//                });

    }

    @Override
    public void start() {
        this.mView.setPresenter(this);
    }

    @Override
    public void onDestory() {
        mView = null;
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }

}
