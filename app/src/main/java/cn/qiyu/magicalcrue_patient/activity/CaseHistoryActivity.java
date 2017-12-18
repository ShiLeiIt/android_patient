package cn.qiyu.magicalcrue_patient.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;

/**
 * Created by ShiLei on 2017/12/18.
 * 病历列表
 */

public class CaseHistoryActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.richscan)
    ImageView mRichscan;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;
    private View mViewCaseHistory;
    private RelativeLayout mRlOutpatient;
    private ImageView mIvOutpatient;
    private TextView mTvOutpatient;
    private TextView mTvOutpatientNum;
    private ImageView mIvLeaveHospital;
    private TextView mTvLeaveHospital;
    private TextView mTvLeaveHospitalNum;
    private ImageView mIvExamine;
    private TextView mTvExamine;
    private TextView mTvExamineNum;
    private ImageView mIvPharmacy;
    private TextView mTvPharmacy;
    private TextView mTvPharmacyNum;
    private RelativeLayout mRlExamine;
    private RelativeLayout mRlPharmacy;
    private RelativeLayout mRlSymptomatography;
    private ImageView mIvSymptomatography;
    private TextView mTvSymptomatography;
    private TextView mTvSymptomatographyNum;
    private Dialog mDialog;
    private RelativeLayout mRlLeaveHospital;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_history);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mRichscan.setVisibility(View.GONE);
        mTvCommit.setVisibility(View.VISIBLE);
        mTvTitle.setText(R.string.caseHistory);

        mViewCaseHistory = findViewById(R.id.ll_case_history);
        //门诊资料
        mRlOutpatient = (RelativeLayout) mViewCaseHistory.findViewById(R.id.icl_outpatient);
        mIvOutpatient = (ImageView) mRlOutpatient.findViewById(R.id.iv_case_history_list_item);
        mTvOutpatient = (TextView) mRlOutpatient.findViewById(R.id.tv_case_history_list_item);
        mTvOutpatientNum = (TextView) mRlOutpatient.findViewById(R.id.tv_case_history_num);
        mTvOutpatient.setText(R.string.outpatientData);
        mTvOutpatientNum.setText("0份");
        mIvOutpatient.setImageResource(R.drawable.outpatient);
        mRlOutpatient.setOnClickListener(this);
        //出院小结
        mRlLeaveHospital = (RelativeLayout) mViewCaseHistory.findViewById(R.id.icl_leave_hospital);
        mIvLeaveHospital = (ImageView) mRlLeaveHospital.findViewById(R.id.iv_case_history_list_item);
        mTvLeaveHospital = (TextView) mRlLeaveHospital.findViewById(R.id.tv_case_history_list_item);
        mTvLeaveHospitalNum = (TextView) mRlLeaveHospital.findViewById(R.id.tv_case_history_num);

        mIvOutpatient.setImageResource(R.drawable.leave_hospital);
        mTvLeaveHospital.setText(R.string.leaveHospital);
        mTvLeaveHospitalNum.setText("0份");
        mRlLeaveHospital.setOnClickListener(this);

        //检查报告单
        mRlExamine = (RelativeLayout) mViewCaseHistory.findViewById(R.id.icl_examine);
        mIvExamine = (ImageView) mRlExamine.findViewById(R.id.iv_case_history_list_item);
        mTvExamine = (TextView) mRlExamine.findViewById(R.id.tv_case_history_list_item);
        mTvExamineNum = (TextView) mRlExamine.findViewById(R.id.tv_case_history_num);
        mIvExamine.setImageResource(R.drawable.examine);
        mTvExamine.setText(R.string.examinationReportSheet);
        mTvExamineNum.setText("0份");
        mRlExamine.setOnClickListener(this);

        //用药方案
        mRlPharmacy = (RelativeLayout) mViewCaseHistory.findViewById(R.id.icl_pharmacy);
        mIvPharmacy = (ImageView) mRlPharmacy.findViewById(R.id.iv_case_history_list_item);
        mTvPharmacy = (TextView) mRlPharmacy.findViewById(R.id.tv_case_history_list_item);
        mTvPharmacyNum = (TextView) mRlPharmacy.findViewById(R.id.tv_case_history_num);
        mIvPharmacy.setImageResource(R.drawable.pharmacy);
        mTvPharmacy.setText(R.string.therapeuticRegimen);
        mTvPharmacyNum.setText("0份");
        mRlPharmacy.setOnClickListener(this);
        //身体症状记录
        mRlSymptomatography = (RelativeLayout) mViewCaseHistory.findViewById(R.id.icl_symptomatography);
        mIvSymptomatography = (ImageView) mRlSymptomatography.findViewById(R.id.iv_case_history_list_item);
        mTvSymptomatography = (TextView) mRlSymptomatography.findViewById(R.id.tv_case_history_list_item);
        mTvSymptomatographyNum = (TextView) mRlSymptomatography.findViewById(R.id.tv_case_history_num);
        mIvSymptomatography.setImageResource(R.drawable.symptomatography);
        mTvSymptomatography.setText(R.string.symptomatography);
        mTvSymptomatographyNum.setText("0份");
        mRlSymptomatography.setOnClickListener(this);
    }

    @OnClick(R.id.tv_commit)
    public void onViewClicked() {
        updateCase();

//        Toast.makeText(this, "提交", Toast.LENGTH_SHORT).show();
    }
    //弹出Dialog
    public void updateCase() {
        View diaolgView = View.inflate(CaseHistoryActivity.this, R.layout.dialog_update_case, null);
        mDialog = new Dialog(CaseHistoryActivity.this, R.style.selectorDialog);
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
        WindowManager m1 = CaseHistoryActivity.this.getWindowManager();
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
                Toast.makeText(CaseHistoryActivity.this, "出院小结", Toast.LENGTH_SHORT).show();
                break;
            //检查报告单
            case R.id.tv_examine:
                Toast.makeText(CaseHistoryActivity.this, "检查报告单", Toast.LENGTH_SHORT).show();
                break;
            //门诊资料
            case R.id.tv_outpatient:
                Toast.makeText(CaseHistoryActivity.this, "门诊资料", Toast.LENGTH_SHORT).show();
                break;
            //症状记录
            case R.id.tv_symptomatography:
                Toast.makeText(CaseHistoryActivity.this, "症状记录", Toast.LENGTH_SHORT).show();
                break;
            //用药方案
            case R.id.tv_pharmacy:
                Toast.makeText(CaseHistoryActivity.this, "用药方案", Toast.LENGTH_SHORT).show();
                break;

            case R.id.iv_update_delete:
                mDialog.dismiss();
                break;
            case R.id.icl_outpatient:
                Toast.makeText(this, "门诊资料1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icl_leave_hospital:
                Toast.makeText(this, "出院小结1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icl_examine:
                Toast.makeText(this, "检查报告单1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icl_pharmacy:
                Toast.makeText(this, "用药方案记录1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icl_symptomatography:
                Toast.makeText(this, "身体症状记录1", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
