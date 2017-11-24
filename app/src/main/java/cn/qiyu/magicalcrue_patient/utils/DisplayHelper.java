package cn.qiyu.magicalcrue_patient.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import cn.qiyu.magicalcrue_patient.R;


/**
 * Created by Administrator on 2017/2/20.
 */

public class DisplayHelper {


    public static void loadGlide(Context context, String path, ImageView view) {
        Glide.with(context)
                .load(path)// 设置加载路径
                .error(R.drawable.banner)
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置磁盘缓存
                .crossFade()// 使用淡入效果
                .into(view);// 设置加载到指定的ImageView


    }
}
