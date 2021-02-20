package com.sun.baseapp.util.imageutil;

import android.content.Context;
import android.widget.ImageView;

/**
 * @author sky
 * @date 2021/1/26
 */
public interface IImage {
    //加载正常图片
    void setNormalImage(Context context, Object url, ImageView imageView);

    //加载圆角图片
    void setRoundedCornersImage(Context context, Object url, int roundedCorner, ImageView imageView);

    //加载圆形图片
    void setCircleCropImage(Context context, Object url, ImageView imageView);
}
