package cn.qiyu.magicalcrue_patient.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.qiyu.magicalcrue_patient.R;

/**
 * 添加门诊资料信息布局抽取
 */

public class LayoutAddOutpatientView extends RelativeLayout {


    private TextView mTvTitle;
    private TextView mTvContent;

    public LayoutAddOutpatientView(Context context) {
        super(context);
    }

    public LayoutAddOutpatientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //将当前组合控件和view关联
        View.inflate(context, R.layout.layout_add_outpatient_data_view, this);
        //转换自定义属性  （获取自定义的属性）
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.LayoutAddOutpatientView);
        //获取文本框的值
        String textTitle = array.getString(R.styleable.LayoutAddOutpatientView_text_Title);

        String textContent = array.getString(R.styleable.LayoutAddOutpatientView_text_content);
        int leftColor = array.getColor(R.styleable.LayoutAddOutpatientView_left, getResources().getColor(R.color.app_userInfor));
        int rightColor = array.getColor(R.styleable.LayoutAddOutpatientView_right, getResources().getColor(R.color.app_gray));
        array.getString(R.styleable.LayoutAddOutpatientView_right);
        array.recycle();
        mTvTitle = (TextView) findViewById(R.id.tv_first_visit);
        mTvTitle.setTextColor(leftColor);
        mTvContent = (TextView) findViewById(R.id.tv_first_visit_time);
        mTvContent.setTextColor(rightColor);
        mTvTitle.setText(TextUtils.isEmpty(textTitle) ? "" : textTitle);
        mTvContent.setText(TextUtils.isEmpty(textContent) ? "" : textContent);


    }

}