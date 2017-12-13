package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.lidong.photopicker.widget.ViewPagerFixed;

import java.util.ArrayList;

import java.util.List;

import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.PhotoPagerAdapter;
import cn.qiyu.magicalcrue_patient.model.EncloSure;


public class CommentImageActivity extends FragmentActivity  {

    private TextView tvNum;
    private ArrayList<String> urlList;

    /**
     * ViewPager
     */
    private ViewPagerFixed viewPager;


    /**
     * 图片资源id
     */
    private List<EncloSure> lists;
    private int indices;
    private Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
//        viewPager = (ViewPager) findViewById(R.id.viewpager);

        tvNum = (TextView) findViewById(R.id.tv_num);
        intent = getIntent();
        lists = (List<EncloSure>) intent.getSerializableExtra("lists");
        initView();
    }

    private void initView() {
        //ViewPagerFixed 解决ViewPager 缩放奔溃问题   java.lang.IllegalArgumentException: pointerIndex out of range 
        viewPager = (ViewPagerFixed) findViewById(R.id.viewpager);
        tvNum = (TextView) findViewById(R.id.tv_num);

        PhotoPagerAdapter viewPagerAdapter = new PhotoPagerAdapter(getSupportFragmentManager(), lists);
        viewPager.setAdapter(viewPagerAdapter);
        indices = Integer.parseInt(intent.getStringExtra("index"));
        viewPager.setCurrentItem(indices);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (null != lists) {
                    tvNum.setText((position + 1) + "/" + lists.size());
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



}

