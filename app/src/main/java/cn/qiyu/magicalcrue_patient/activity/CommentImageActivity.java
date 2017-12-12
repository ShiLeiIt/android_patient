package cn.qiyu.magicalcrue_patient.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.PagerAdapterImpl;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.EncloSure;

/**
 * 随访对话，评论中，图片预览
 */
public class CommentImageActivity extends BaseActivity {

    @Bind(R.id.tv_current)
    TextView tvCurrent;
    @Bind(R.id.tv_count)
    TextView tvCount;
    /**
     * ViewPager
     */
    private ViewPager viewPager;


    /**
     * 图片资源id
     */
    private List<EncloSure> lists;
    private int indices;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        lists = (List<EncloSure>) intent.getSerializableExtra("lists");
        indices = Integer.parseInt(intent.getStringExtra("index"));
        initView();
        initEvent();
        tvCount.setText(lists.size()+"");
        tvCurrent.setText((indices+1)+"");
        viewPager.setCurrentItem(indices);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initEvent() {
        viewPager.setAdapter(new PagerAdapterImpl(this, lists));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvCurrent.setText((position+1)+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}

