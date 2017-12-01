package cn.qiyu.magicalcrue_patient.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

import cn.qiyu.magicalcrue_patient.MyApplication;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.fragment.HomePageFragment;
import cn.qiyu.magicalcrue_patient.fragment.InformationFragment;
import cn.qiyu.magicalcrue_patient.fragment.MineFragment;
import cn.qiyu.magicalcrue_patient.fragment.VisitFragment;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;

/**
 * Created by Administrator on 2017/11/13.
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_VISIT = "随访";
    private static final String TAG_PAGE_ADD = "";
    private static final String TAG_PAGE_INFORMATION = "消息";
    private static final String TAG_PAGE_PERSON = "个人";
    private MainNavigateTabBar mNavigateTabBar;
    private String mUuid;
    private long mExitTime;
    private Dialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication.getInstance().addActivity(this);

        mNavigateTabBar = (MainNavigateTabBar) findViewById(R.id.mainTabBar);
        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);
        mNavigateTabBar.addTab(HomePageFragment.class, new MainNavigateTabBar.TabParam(R.drawable.tab_home_normal, R.drawable.tab_home_select, TAG_PAGE_HOME));
        mNavigateTabBar.setCurrentSelectedTab(R.drawable.tab_home_select);

        mNavigateTabBar.addTab(VisitFragment.class, new MainNavigateTabBar.TabParam(R.drawable.tab_visit_normal, R.drawable.tab_visit_select, TAG_PAGE_VISIT));
        mNavigateTabBar.setCurrentSelectedTab(R.drawable.tab_visit_select);

        mNavigateTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, TAG_PAGE_ADD));

        mNavigateTabBar.addTab(InformationFragment.class, new MainNavigateTabBar.TabParam(R.drawable.tab_information_normal, R.drawable.tab_information_select, TAG_PAGE_INFORMATION));
        mNavigateTabBar.setCurrentSelectedTab(R.drawable.tab_information_select);

        mNavigateTabBar.addTab(MineFragment.class, new MainNavigateTabBar.TabParam(R.drawable.tab_mine_normal, R.drawable.tab_mine_select, TAG_PAGE_PERSON));
        mNavigateTabBar.setCurrentSelectedTab(R.drawable.tab_mine_select);


    }



    public void changFragment(String title) {
        mNavigateTabBar.showFragment(title,4);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_BACK:
//                if ((System.currentTimeMillis() - mExitTime) > 2000) {
//                    Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                    mExitTime = System.currentTimeMillis();
//                } else {
//                    MyApplication.getInstance().exit();
//                    finish();
//                }
//                break;
//            default:
//                return super.onKeyDown(keyCode, event);
//        }
//        return true;
//
//    }

    public void onClickPublish(View v) {
        updateCase();

//        Toast.makeText(this, "Add", Toast.LENGTH_LONG).show();
    }

    //弹出dialog
    public void updateCase() {

        View diaolgView = View.inflate(MainActivity.this, R.layout.dialog_update_case, null);
        mDialog = new Dialog(MainActivity.this, R.style.selectorDialog);
        mDialog.setContentView(diaolgView);
        TextView tv_iconography = (TextView) mDialog.findViewById(R.id.tv_iconography);
        TextView tv_laboratory = (TextView) mDialog.findViewById(R.id.tv_laboratory);
        TextView tv_gene = (TextView) mDialog.findViewById(R.id.tv_gene);
        TextView tv_symptomatography = (TextView) mDialog.findViewById(R.id.tv_symptomatography);
        TextView tv_pharmacy = (TextView) mDialog.findViewById(R.id.tv_pharmacy);
        TextView tv_leave_hospital = (TextView) mDialog.findViewById(R.id.tv_leave_hospital);
        TextView tv_outpatient = (TextView) mDialog.findViewById(R.id.tv_outpatient);
        ImageView iv_update_detele = (ImageView) mDialog.findViewById(R.id.iv_update_delete);

        tv_iconography.setOnClickListener(this);
        tv_laboratory.setOnClickListener(this);
        tv_gene.setOnClickListener(this);
        tv_symptomatography.setOnClickListener(this);
        tv_pharmacy.setOnClickListener(this);
        tv_leave_hospital.setOnClickListener(this);
        tv_outpatient.setOnClickListener(this);
        tv_iconography.setOnClickListener(this);
        iv_update_detele.setOnClickListener(this);

        mDialog.show();
        Window dialog1Window = mDialog.getWindow();
        WindowManager m1 = MainActivity.this.getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        m1.getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams p1 = dialog1Window.getAttributes();
        p1.height = (int) (dm.heightPixels * 1.0);
        p1.width = (int) (dm.widthPixels * 1.0);
        p1.alpha = 1.0f;
        dialog1Window.setAttributes(p1);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //摄像学检查
            case R.id.tv_iconography:
                Toast.makeText(MainActivity.this, "摄像学检查", Toast.LENGTH_SHORT).show();
                break;
            //实验室检查
            case R.id.tv_laboratory:
                Toast.makeText(MainActivity.this, "实验室检查", Toast.LENGTH_SHORT).show();
                break;
            //基因检测
            case R.id.tv_gene:
                Toast.makeText(MainActivity.this, "基因检测", Toast.LENGTH_SHORT).show();
                break;
            //症状记录
            case R.id.tv_symptomatography:
                Toast.makeText(MainActivity.this, "症状记录", Toast.LENGTH_SHORT).show();
                break;
            //用药方案
            case R.id.tv_pharmacy:
                Toast.makeText(MainActivity.this, "用药方案", Toast.LENGTH_SHORT).show();
                break;
            //出院小结
            case R.id.tv_leave_hospital:
                Toast.makeText(MainActivity.this, "出院小结", Toast.LENGTH_SHORT).show();
                break;
            //门诊资料
            case R.id.tv_outpatient:
                Toast.makeText(MainActivity.this, "门诊资料", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_update_delete:
                mDialog.dismiss();
                break;
        }
    }
}
