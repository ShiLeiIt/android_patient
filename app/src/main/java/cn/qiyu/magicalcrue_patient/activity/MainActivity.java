package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.fragment.HomePageFragment;
import cn.qiyu.magicalcrue_patient.fragment.InformationFragment;
import cn.qiyu.magicalcrue_patient.fragment.MineFragment;
import cn.qiyu.magicalcrue_patient.fragment.VisitFragment;

/**
 * Created by Administrator on 2017/11/13.
 */

public class MainActivity extends FragmentActivity {
    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_VISIT = "随访";
    private static final String TAG_PAGE_ADD = "";
    private static final String TAG_PAGE_INFORMATION = "消息";
    private static final String TAG_PAGE_PERSON = "我的";
    private MainNavigateTabBar mNavigateTabBar;
    private String mUuid;

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
        Log.i("patient====", getIntent().getStringExtra("patientuuid"));
        Log.i("uuid====", getIntent().getStringExtra("uuid"));
//        Log.i("userid====", getIntent().getStringExtra("userid"));

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }

    public void onClickPublish(View v) {
        Toast.makeText(this, "Add", Toast.LENGTH_LONG).show();
    }


}
