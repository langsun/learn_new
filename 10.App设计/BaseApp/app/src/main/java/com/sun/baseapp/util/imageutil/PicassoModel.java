package com.sun.baseapp.util.imageutil;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * @author sky
 * @date 2021/1/26
 */
public class PicassoModel implements IImage {

    @Override
    public void setNormalImage(Context context, Object url, ImageView imageView) {
        Picasso.get().load((String) url).into(imageView);
    }

    @Override
    public void setRoundedCornersImage(Context context, Object url, int roundedCorner, ImageView imageView) {

    }

    @Override
    public void setCircleCropImage(Context context, Object url, ImageView imageView) {

    }
}
