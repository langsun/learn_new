package com.sun.baseapp.util.imageutil;

import android.content.Context;
import android.widget.ImageView;

/**
 * @author sky
 * @date 2021/1/26
 */
public class ImageProxy implements IImage {
    private static IImage mImage = null;
    private static ImageProxy mInstance;

    private ImageProxy() {
    }

    public static ImageProxy obtain() {
        if (mInstance == null) {
            synchronized (ImageProxy.class) {
                if (mInstance == null) {
                    mInstance = new ImageProxy();
                }
            }
        }
        return mInstance;
    }

    public static void init(IImage image) {
        mImage = image;
    }


    @Override
    public void setNormalImage(Context context, Object url, ImageView imageView) {
        mImage.setNormalImage(context, url, imageView);
    }

    @Override
    public void setRoundedCornersImage(Context context, Object url, int roundedCorner, ImageView imageView) {
        mImage.setRoundedCornersImage(context, url, roundedCorner, imageView);
    }

    @Override
    public void setCircleCropImage(Context context, Object url, ImageView imageView) {
        mImage.setCircleCropImage(context, url, imageView);
    }
}
