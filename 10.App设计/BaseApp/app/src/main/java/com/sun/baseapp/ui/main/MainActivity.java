package com.sun.baseapp.ui.main;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sun.baseapp.R;
import com.sun.baseapp.base.BaseActivity;
import com.sun.baseapp.ui.main.bean.MainData;
import com.sun.baseapp.util.imageutil.ImageProxy;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View{
    @BindView(R.id.iv_image)
    ImageView mImageView;

    private String url = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png";

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
//        Glide.with(this).load(url).into(mImageView);
        ImageProxy.obtain().setNormalImage(this, url, mImageView);
    }

    @Override
    public void getDataSuccess(MainData result) {

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
