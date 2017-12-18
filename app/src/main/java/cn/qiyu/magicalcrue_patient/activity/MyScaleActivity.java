package cn.qiyu.magicalcrue_patient.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.TabAdapter;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;

/**
 * Created by ShiLei on 2017/11/30.
 */

public class MyScaleActivity extends BaseActivity {
    @Bind(R.id.tl_container)
    TabLayout tlContainer;
    @Bind(R.id.vp_container)
    ViewPager vp_container;

    private TabLayout.Tab tab_1, tab_2, tab_3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scale);
        ButterKnife.bind(this);
        initview();
        initevents();
    }

    private void initview() {
        // 在 fragment 中进行绑定
        ButterKnife.bind(this);
        //给ViewPager设置适配器
        vp_container.setAdapter(new TabAdapter(getSupportFragmentManager()));
        //将TabLayout和ViewPager关联起来。
        tlContainer.setupWithViewPager(vp_container);
        //设置可以滑动
        //tlContainer.setTabMode(TabLayout.MODE_SCROLLABLE);
        //进入该Fragment显示第一个tab的方法
        tab_1 = tlContainer.getTabAt(0);
        tab_2 = tlContainer.getTabAt(1);
        tab_3 = tlContainer.getTabAt(2);
        vp_container.setCurrentItem(0);

    }

    private void initevents() {
        tlContainer.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == tab_1) {
                    vp_container.setCurrentItem(0);
                } else if (tab == tab_2) {
                    vp_container.setCurrentItem(1);
                } else if (tab == tab_3) {
                    vp_container.setCurrentItem(2);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getExtras() != null) {
            if (intent.getExtras().getString("doctorScale").equals("doctorScale")) {
                vp_container.setCurrentItem(0);
            }
        }
    }
}
