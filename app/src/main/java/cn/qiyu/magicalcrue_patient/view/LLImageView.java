package cn.qiyu.magicalcrue_patient.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.qiyu.magicalcrue_patient.R;

/**
 * Created by ShiLei on 2017/11/14.
 */
public class LLImageView extends LinearLayout {
    private Context mContext;
    private LinearLayout mLl;

    public LLImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.view_llimageview, this, true);
        mLl = (LinearLayout) findViewById(R.id.ll);
    }
    public void setDatas(String[] array) {
        if (array == null || array.length < 1){
            return;
        }
        for (int i = 0; i < array.length; i++) {
            ImageView imageView = new ImageView(mContext);
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//图片的宽高
            lp.setMargins(10,5,0,0);
            imageView.setLayoutParams(lp);  //设置图片宽高
            imageView.setImageResource(R.drawable.home_doctor_head); //图片资源
            mLl.addView(imageView); //动态添加图片
        }
    }
}
