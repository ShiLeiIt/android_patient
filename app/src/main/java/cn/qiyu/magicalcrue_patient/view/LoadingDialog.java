package cn.qiyu.magicalcrue_patient.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.qiyu.magicalcrue_patient.R;


public class LoadingDialog extends Dialog {
    private TextView tv;

    public LoadingDialog(Context context) {
        super(context, R.style.loadingDialogStyle);
    }

    private LoadingDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        tv = (TextView)this.findViewById(R.id.tv);
        tv.setText("正在保存...");
        LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.LinearLayout);
        linearLayout.getBackground().setAlpha(210);
    }
}