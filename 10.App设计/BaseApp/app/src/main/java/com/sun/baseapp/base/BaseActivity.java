package com.sun.baseapp.base;

import android.content.Context;
import android.os.Bundle;

import com.sun.baseapp.App;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected static final String TAG = BaseActivity.class.getSimpleName();

    protected App mApplication;
    private Unbinder mUnbinder;
    protected P mPresenter;

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        mApplication = (App) getApplication();
        mContext = this;

        setContentView(layoutId());
        mUnbinder = ButterKnife.bind(this);
        initData();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
        if(mPresenter !=null){
            mPresenter.onDestory();
        }
        this.mPresenter = null;
        this.mUnbinder = null;
        this.mApplication = null;
    }


    protected abstract int layoutId();

    protected abstract void initData();
}
