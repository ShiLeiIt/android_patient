package cn.qiyu.magicalcrue_patient.activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.ListItemAdapter;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.visit.FollowUpDialoguePresenter;
import cn.qiyu.magicalcrue_patient.visit.FollowUpDialogueView;


/**
 * 随访消息详情
 */
public class FollowUpMessageDetailActivity extends AppCompatActivity {

    @Bind(R.id.lv_follow_up_Detail)
    ListView lvFollowUpDetail;
    @Bind(R.id.ll_message_send)
    LinearLayout llMessageSend;
    @Bind(R.id.et_reply_patient)
    EditText etReplyPatient;
    private String patientId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_up_message_detail);
        ButterKnife.bind(this);
        mFollowUpDialoguePresenter.getFollowUpDialogue();

    }
    FollowUpDialoguePresenter mFollowUpDialoguePresenter = new FollowUpDialoguePresenter(new FollowUpDialogueView() {
        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPagecount() {
            return "100";
        }

        @Override
        public String getUserUuid() {
            return (String) PreUtils.getParam(FollowUpMessageDetailActivity.this,"uuid","");
        }

        @Override
        public String getUserType() {
            return "1";
        }

        @Override
        public void LoadFollowUpDialogue(ResultModel<List<FollowUpMessageDetaild>> model) {
//            Toast.makeText(FollowUpMessageDetailActivity.this, ""+model.getData().size(), Toast.LENGTH_SHORT).show();
            ListItemAdapter listItemAdapter = new ListItemAdapter(FollowUpMessageDetailActivity.this, FollowUpMessageDetailActivity.this, model.getData());
            lvFollowUpDetail.setAdapter(listItemAdapter);
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(FollowUpMessageDetailActivity.this, ""+model.getMessage(), Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(FollowUpMessageDetailActivity.this, ""+e, Toast.LENGTH_SHORT).show();
        }
    });


}
