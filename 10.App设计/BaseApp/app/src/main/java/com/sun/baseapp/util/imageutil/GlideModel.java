package com.sun.baseapp.util.imageutil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ViewTarget;

/**
 * @author sky
 * @date 2021/1/26
 */
public class GlideModel implements IImage {
    @Override
    public void setNormalImage(Context context, Object url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);

        RequestManager requestManager = Glide.with(context);
        RequestBuilder<Drawable> requestBuilder = requestManager.load(url);
        ViewTarget<ImageView, Drawable> viewTarget = requestBuilder.into(imageView);

    }

    @Override
    public void setRoundedCornersImage(Context context, Object url, int roundedCorner, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .transform(new GlideRoundTransform(context, roundedCorner));
//                .placeholder(R.drawable.user_icon_default)
//                .error(R.drawable.user_icon_default);
        Glide.with(context).load(url).apply(myOptions).into(imageView);
    }

    @Override
    public void setCircleCropImage(Context context, Object url, ImageView imageView) {
        RequestOptions myOptions = new RequestOptions()
                .transform(new CircleCrop());
//                .placeholder(R.drawable.user_icon_default)
//                .error(R.drawable.user_icon_default);
        Glide.with(context).load(url).apply(myOptions).into(imageView);
    }
//    /**
//     * 加载圆形图片
//     *
//     * @param context
//     * @param url
//     * @param roundedCorner
//     * @param imageView
//     */
//    public static void setRoundedCornersImage(Context context, Object url, int roundedCorner, ImageView imageView) {
//        RequestOptions myOptions = new RequestOptions()
//                .transform(new GlideRoundTransform(context, roundedCorner));
////                .placeholder(R.drawable.user_icon_default)
////                .error(R.drawable.user_icon_default);
//        Glide.with(context).load(url).apply(myOptions).into(imageView);
//    }
//
//
//    /**
//     * 加载圆形图片
//     *
//     * @param context
//     * @param url
//     * @param imageView
//     */
//    public static void setCircleCropImage(Context context, Object url, ImageView imageView) {
//        RequestOptions myOptions = new RequestOptions()
//                .transform(new CircleCrop());
////                .placeholder(R.drawable.user_icon_default)
////                .error(R.drawable.user_icon_default);
//        Glide.with(context).load(url).apply(myOptions).into(imageView);
//    }
//
//    /**
//     * 加载z正常图片
//     *
//     * @param context
//     * @param url
//     * @param imageView
//     */
//    public static void setNormalImage(Context context, Object url, ImageView imageView) {
//        Glide.with(context).load(url).into(imageView);
//    }

}
