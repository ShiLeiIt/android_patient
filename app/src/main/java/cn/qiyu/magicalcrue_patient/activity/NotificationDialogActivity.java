package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;

/**
 * 加入系统通知Dialog
 */
public class NotificationDialogActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_dialog);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv_into_notification, R.id.tv_exit_notification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_into_notification:
                //Toast.makeText(this, "版本号："+Build.VERSION.SDK_INT, Toast.LENGTH_SHORT).show();
                requestPermission(Build.VERSION.SDK_INT);

                finish();
                break;
            case R.id.tv_exit_notification:
                finish();
                break;
        }
    }
    protected void requestPermission(int requestCode) {
        // TODO Auto-generated method stub
        // 6.0以上系统才可以判断权限

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
            // 进入设置系统应用权限界面
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 运行系统在5.x环境使用
            // 进入设置系统应用权限界面
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return;
        }
        return;
    }
}
