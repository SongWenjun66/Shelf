package com.song.frame.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.song.frame.R;

/**
 * Created by  宋文俊 on 2019/1/15.
 */
public class GlideUtils {
    public static void load(Activity context, String string, ImageView imageView){
        RequestOptions options = new RequestOptions()
                .error(R.mipmap.default_error)
                .placeholder(R.drawable.loading)
                .centerCrop();
        Glide.with(context)
                .load(string)
                .apply(options)
                .into(imageView);
    }
   public static void loadnolder(Activity context, String string, ImageView imageView){
        RequestOptions options = new RequestOptions()
                .error(R.mipmap.default_error)
                .centerCrop();
        Glide.with(context)
                .load(string)
                .apply(options)
                .into(imageView);
    }
    public static void loaderr(Activity context, String string, ImageView imageView, int id){
        RequestOptions options = new RequestOptions()
                .error(id)
                .centerCrop();
        Glide.with(context)
                .load(string)
                .apply(options)
                .into(imageView);
    }
}
