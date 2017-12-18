package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.view.LayoutAddOutpatientView;

/**
 * Created by ShiLei on 2017/12/18.
 * 症状描述
 */

public class SymptomDescriptionsActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;
    @Bind(R.id.lav_symptom)
    LayoutAddOutpatientView mLavSymptom;
    @Bind(R.id.lav_custom_symptom)
    LayoutAddOutpatientView mLavCustomSymptom;
    @Bind(R.id.id_editor_detail)
    EditText mIdEditorDetail;
    @Bind(R.id.id_editor_detail_font_count)
    TextView mIdEditorDetailFontCount;
    @Bind(R.id.iv_quiz_pic)
    ImageView mIvQuizPic;
    @Bind(R.id.gridView)
    GridView mGridView;
    @Bind(R.id.ll_symptom_descriptions)
    LinearLayout mLlSymptomDescriptions;
    private TextView mTvSymptom;
    private TextView mTvCustomSymptom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_descriptions);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText(R.string.symptomaDescriptions);
        mTvCommit.setVisibility(View.VISIBLE);
        mTvCommit.setText(R.string.commit);
        //症状
        mTvSymptom = (TextView) mLavSymptom.findViewById(R.id.tv_first_visit_time);
        //自定义症状
        mTvCustomSymptom = (TextView) mLavCustomSymptom.findViewById(R.id.tv_first_visit_time);
//        mTvCommit.setOnClickListener(this);
//        mTvSymptom.setOnClickListener(this);
        mLavSymptom.setOnClickListener(this);
        mLavCustomSymptom.setOnClickListener(this);
        mTvCommit.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_commit:
                Toast.makeText(this, "提交", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lav_symptom:
                Toast.makeText(this, "症状", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lav_custom_symptom:
                Toast.makeText(this, "自定义症状", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
