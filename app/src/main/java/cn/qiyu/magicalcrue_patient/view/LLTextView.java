package cn.qiyu.magicalcrue_patient.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.qiyu.magicalcrue_patient.R;

/**
 * Created by ShiLei on 2017/11/14.
 */
public class LLTextView extends LinearLayout {

    private Context mContext;
    private String   mTopLeftName;
    private String   mTopRightName;
    private String   mBottomName;
    private TextView mTopLeft;
    private TextView mTopRight;
    private TextView mBottom;
    public LLTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LLTextView);
        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.LLTextView_topLeftName:
                    mTopLeftName = typedArray.getString(attr);
                    break;
                case R.styleable.LLTextView_topRightName:
                    mTopRightName = typedArray.getString(attr);
                    break;
                case R.styleable.LLTextView_bottomName:
                    mBottomName = typedArray.getString(attr);
                    break;
            }
        }
        typedArray.recycle();
        init();
    }
    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.view_ll_textview, this, true);
        mTopLeft = (TextView) findViewById(R.id.tv_top_left);
        mTopRight = (TextView) findViewById(R.id.tv_top_right);
        mBottom = (TextView) findViewById(R.id.tv_bottom);
        mTopLeft.setText(TextUtils.isEmpty(mTopLeftName)?"": mTopLeftName);
        mTopRight.setText(TextUtils.isEmpty(mTopRightName)?"": mTopRightName);
        mBottom.setText(TextUtils.isEmpty(mBottomName)?"": mBottomName);
    }
}
