package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.model.ScaleTitleBean;


public class ScaleDetailActivity extends AppCompatActivity {

    @Bind(R.id.rv_scale_detail)
    RecyclerView rvScaleDetail;
    private ScaleDetailBean questionnaireDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        questionnaireDetail = (ScaleDetailBean) intent.getSerializableExtra("scaleDetail");
        Log.i("scalebean", "" + questionnaireDetail.getQuestionList().get(0).getOptionsList().size());
        rvScaleDetail.setAdapter(new RecyclerAdpter(questionnaireDetail.getQuestionList()));
        rvScaleDetail.setLayoutManager(new LinearLayoutManager(ScaleDetailActivity.this));

    }

    @OnClick({R.id.iv_exit_mine, R.id.tv_send_patient})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_exit_mine:
                finish();
                break;
            case R.id.tv_send_patient:
//                scalePresenter.getPatientByFollowDoctorList();
                break;

        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind({R.id.tv_question_title})
        TextView mtextview;
        @Bind(R.id.ll_question_option_container)
        LinearLayout linearLayout;
        ScaleTitleBean mModel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setItem(ScaleTitleBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView(int num) {
            linearLayout.removeAllViews();

            String type = "";
            switch (mModel.getQuestionType()) {
                case "radio":
                case "checkbox":
                    if (mModel.getQuestionType().equals("radio"))
                        type = "（单选）";
                    else
                        type = "（多选）";


                    for (int i = 0; i < mModel.getOptionsList().size(); i++) {
                        final LinearLayout linearLayout1 = new LinearLayout(ScaleDetailActivity.this);
                        if (mModel.getQuestionType().equals("radio")) {
                            RadioButton rb = new RadioButton(ScaleDetailActivity.this);
                            rb.setButtonDrawable(R.drawable.selector_choose);
                        }
                        CheckBox checkBox = new CheckBox(ScaleDetailActivity.this);
                        checkBox.setButtonDrawable(R.drawable.selector_choose);
                        linearLayout1.addView(checkBox);
                        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);

                        TextView textView = new TextView(ScaleDetailActivity.this);
                        textView.setPadding(40, 0, 0, 0);
                        textView.setTextSize(16);
                        textView.setGravity(Gravity.CENTER_HORIZONTAL);
                        textView.setText(mModel.getOptionsList().get(i).getContent());
                        textView.setTextColor(getResources().getColor(R.color.app_gray));
                        linearLayout1.addView(textView);
                        linearLayout1.setPadding(0, 20, 0, 0);
                        linearLayout.addView(linearLayout1);
                    }
                    break;
                default:
                    type = "(描述)";
                    EditText editText = new EditText(ScaleDetailActivity.this);
                    editText.setBackgroundResource(R.drawable.edit_scale_detail);
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.setKeyListener(null);
                    linearLayout.addView(editText);
                    break;
            }
            mtextview.setText((num + 1) + "、" + mModel.getContent().toString() + type);
        }
    }

    class RecyclerAdpter extends RecyclerView.Adapter<ViewHolder> {
        private List<ScaleTitleBean> mlist;

        public RecyclerAdpter(List<ScaleTitleBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(ScaleDetailActivity.this).inflate(R.layout.recyclerview_item_option, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView(position);
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }
//    ScalePresenter scalePresenter=new ScalePresenter(new ScaleLoadPatientInfoView() {
//        @Override
//        public String getDoctorId() {
//            return (String) PreUtils.getParam(ScaleDetailActivity.this, "uuid", "0");
//        }
//
//        @Override
//        public String getPage() {
//            return "0";
//        }
//
//        @Override
//        public String getPageCount() {
//            return "100";
//        }
//
//        @Override
//        public void getPatientByFollowDoctorList(ResultModel<List<PatientInfo>> model) {
//            Intent intent=new Intent(ScaleDetailActivity.this,FollowUpPatientActivity.class);
//            intent.putExtra("paper",questionnaireDetail.getPaperID());
//           intent.putExtra("patientList", (Serializable) model.getData());
//            startActivity(intent);
//        }
//
//        @Override
//        public void showProgress() {
//
//        }
//
//        @Override
//        public void hideProgress() {
//
//        }
//
//        @Override
//        public void onViewFailure(ResultModel model) {
//            Toast.makeText(ScaleDetailActivity.this, model.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onServerFailure(String e) {
//            Toast.makeText(ScaleDetailActivity.this, ""+e, Toast.LENGTH_SHORT).show();
//        }
//    });

}
