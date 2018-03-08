package cn.qiyu.magicalcrue_patient.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.fragment.HomePageFragment;
import cn.qiyu.magicalcrue_patient.fragment.InformationFragment;
import cn.qiyu.magicalcrue_patient.fragment.MineFragment;
import cn.qiyu.magicalcrue_patient.fragment.VisitFragment;

/**
 * Created by Administrator on 2017/11/13.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
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
        //注册EventBus，在开始的位置
        //EventBus.getDefault().register(this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //注册EventBus，在开始的位置
        //EventBus.getDefault().register(this);
    }

    //
    public void changFragment(String title) {
        mNavigateTabBar.showFragment(title,4);
    }

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }


    public void onClickPublish(View v) {
        updateCase();

//        Toast.makeText(this, "Add", Toast.LENGTH_LONG).show();
    }

    //弹出dialog
    public void updateCase() {

        View diaolgView = View.inflate(MainActivity.this, R.layout.dialog_update_case, null);
        mDialog = new Dialog(MainActivity.this, R.style.selectorDialog);
        mDialog.setContentView(diaolgView);
        //出院小结
        TextView tvLeaveHospital = (TextView) mDialog.findViewById(R.id.tv_leave_hospital);
        //检查报告单
        TextView tvExamine = (TextView) mDialog.findViewById(R.id.tv_examine);
        //门诊资料
        TextView tvOutpatient = (TextView) mDialog.findViewById(R.id.tv_outpatient);
        //症状记录
        TextView tvSymptomatography = (TextView) mDialog.findViewById(R.id.tv_symptomatography);
        //用药方案
        TextView tvPharmacy = (TextView) mDialog.findViewById(R.id.tv_pharmacy);


        ImageView ivUpdateDetele = (ImageView) mDialog.findViewById(R.id.iv_update_delete);


        tvLeaveHospital.setOnClickListener(this);
        tvExamine.setOnClickListener(this);
        tvOutpatient.setOnClickListener(this);
        tvSymptomatography.setOnClickListener(this);
        tvPharmacy.setOnClickListener(this);


        ivUpdateDetele.setOnClickListener(this);

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
            //出院小结
            case R.id.tv_leave_hospital:
//                Toast.makeText(MainActivity.this, "出院小结", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LeaveHospitalInfoListActivity.class);
                intent.putExtra("leaveHospital", "leaveHospital");
                startActivity(intent);
                break;
            //检查报告单
            case R.id.tv_examine:
//                Toast.makeText(MainActivity.this, "检查报告单", Toast.LENGTH_SHORT).show();
                Intent intentI = new Intent(MainActivity.this, InspectionReportInfoListActivity.class);
                startActivity(intentI);
                break;
            //门诊资料
            case R.id.tv_outpatient:
                Intent intent1 = new Intent(MainActivity.this, OutpatientInformationListActivity.class);
                intent1.putExtra("outPatient", "outPatient");
                startActivity(intent1);
//                Toast.makeText(MainActivity.this, "门诊资料", Toast.LENGTH_SHORT).show();
                break;

            //症状记录
            case R.id.tv_symptomatography:
//                Toast.makeText(MainActivity.this, "症状记录", Toast.LENGTH_SHORT).show();
                Intent intentS = new Intent(MainActivity.this, SymgraphyInfoListActivity.class);
                startActivity(intentS);
                break;
            //用药方案
            case R.id.tv_pharmacy:
//                Toast.makeText(MainActivity.this, "用药方案", Toast.LENGTH_SHORT).show();
                Intent intentP = new Intent(MainActivity.this, PharmacyPlanRecordInfoListActivity.class);
                startActivity(intentP);
                break;

            case R.id.iv_update_delete:
                mDialog.dismiss();
                break;
        }
    }

//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        if (intent!=null&& intent.getExtras()!=null){
//            if(intent.getExtras().getString("doctorNotice").equals("doctorNotice")){
//                changFragment("消息");
//            }
//        }

//    }


}

