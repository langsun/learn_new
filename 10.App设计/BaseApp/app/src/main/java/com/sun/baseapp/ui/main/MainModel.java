package com.sun.baseapp.ui.main;


import com.sun.baseapp.ui.main.bean.MainData;

import io.reactivex.Observable;

public class MainModel implements MainContract.Model{
    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public boolean isSucess() {
        return false;
    }

    @Override
    public Observable<MainData> getData() {
        return null;
    }
}
