package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.model.ScaleTitleBean;

public class ScaleDetailShowActivity extends BaseActivity {

    @Bind(R.id.rv_scale_detail)
    RecyclerView rvScaleDetail;
    @Bind(R.id.tv_send_patient)
    TextView tvSendPatient;
    @Bind(R.id.iv_exit_mine)
    ImageView mIvExitMine;
    private ScaleDetailBean questionnaireDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_detail_show);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        tvSendPatient.setVisibility(View.GONE);
        questionnaireDetail = (ScaleDetailBean) intent.getSerializableExtra("scaleDetail");
//        mPaperUserID = intent.getStringExtra("paperUserID");
        rvScaleDetail.setAdapter(new RecyclerAdpter(questionnaireDetail.getQuestionList()));
        rvScaleDetail.setLayoutManager(new LinearLayoutManager(ScaleDetailShowActivity.this));

    }

    @OnClick(R.id.iv_exit_mine)
    public void onViewClicked() {
        finish();
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
                        LinearLayout linearLayout1 = new LinearLayout(ScaleDetailShowActivity.this);
                        final CheckBox checkBox = new CheckBox(ScaleDetailShowActivity.this);
                        checkBox.setButtonDrawable(R.drawable.selector_choose);
                        checkBox.setTextColor(ScaleDetailShowActivity.this.getResources().getColor(R.color.app_gray));
                        checkBox.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            if (checkBox.isChecked())
                                                                checkBox.setChecked(false);

                                                            else
                                                                checkBox.setChecked(true);
                                                        }
                                                    }
                        );
                        for (int j = 0; j < mModel.getAnswerOptionIOS().size(); j++) {
                            if (mModel.getOptionsList().get(i).getOptionID().equals(mModel.getAnswerOptionIOS().get(j))) {
                                checkBox.setChecked(true);

                            }
                        }
                        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
                        linearLayout1.addView(checkBox);
                        TextView textView = new TextView(ScaleDetailShowActivity.this);
                        textView.setPadding(40, 0, 0, 0);
                        textView.setTextSize(16);
                        textView.setGravity(Gravity.CENTER_HORIZONTAL);
                        textView.setText(mModel.getOptionsList().get(i).getContent());
                        textView.setTextColor(ScaleDetailShowActivity.this.getResources().getColor(R.color.app_gray));
                        linearLayout1.addView(textView);
                        linearLayout1.setPadding(0, 20, 0, 0);
                        linearLayout.addView(linearLayout1);
                    }
                    break;
                default:
                    type = "(描述)";
                    EditText editText = new EditText(ScaleDetailShowActivity.this);
                    editText.setBackgroundResource(R.drawable.edit_scale_detail);
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.setKeyListener(null);
                    editText.setPadding(20, 20, 20, 20);
                    editText.setText(mModel.getAnswerResult());
                    editText.setTextColor(ScaleDetailShowActivity.this.getResources().getColor(R.color.app_gray));
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
            return new ViewHolder(LayoutInflater.from(ScaleDetailShowActivity.this).inflate(R.layout.recyclerview_item_option_show, null));
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


}
