package cn.qiyu.magicalcrue_patient.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.ListItemAdapter;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.home.HomePresenter;
import cn.qiyu.magicalcrue_patient.information.InformationFollowUpRdView;
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.HomeBannerBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.visit.FollowUpDialoguePresenter;
import cn.qiyu.magicalcrue_patient.visit.FollowUpDialogueView;


/**
 * 随访消息详情
 */
public class FollowUpMessageDetailActivity extends BaseActivity {

    @Bind(R.id.lv_follow_up_Detail)
    ListView lvFollowUpDetail;
    @Bind(R.id.ll_message_send)
    LinearLayout llMessageSend;
    @Bind(R.id.et_reply_patient)
    EditText etReplyPatient;
    @Bind(R.id.tv_condition_quiz)
    TextView mTvConditionQuiz;
    @Bind(R.id.btn_send_message)
    Button mBtnSendMessage;
    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;
    private String mErrorCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_up_message_detail);
        ButterKnife.bind(this);


        //获取屏幕高度
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        //阀值设置为屏幕高度的1/3
        keyHeight = screenHeight / 3;
        mInformationPresenter.getFollowUpMsgRead();

    }
    //获取mErrorCode值
    HomePresenter mHomePresenter = new HomePresenter(new HomeNumView() {
        @Override
        public String getUserId() {
            return "";
        }

        @Override
        public void LoadDate(ResultModel<HomeNumBean> numBean) {

        }

        @Override
        public String patientUuid() {
            return (String)PreUtils.getParam(FollowUpMessageDetailActivity.this,"patientuuid","0");
        }

        @Override
        public String DoctorUuid() {
            return null;
        }

        @Override
        public void getDoctorQRcode(ResultModel model) {


        }

        @Override
        public void LoadDoctorTeamInfor(ResultModel<DoctorTeamBean> model) {

        }

        @Override
        public String getType() {
            return null;
        }

        @Override
        public void LoadHomeBanner(ResultModel<List<HomeBannerBean>> model) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            mErrorCode = model.getErrorCode();
            if (mErrorCode.equals("1001")) {
                mTvConditionQuiz.setVisibility(View.INVISIBLE);
            } else if (mErrorCode.equals("1002")) {
                mTvConditionQuiz.setVisibility(View.INVISIBLE);
            } else {
                mTvConditionQuiz.setVisibility(View.VISIBLE);
            }
            Log.i("errorId==============", mErrorCode);

        }

        @Override
        public void onServerFailure(String e) {

        }
    });


    //消息已读
    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationFollowUpRdView() {
        @Override
        public String getUserUuid() {
            return (String)PreUtils.getParam(FollowUpMessageDetailActivity.this,"uuid","0");
        }

        @Override
        public void LoadFollowUpMsgRead(ResultModel model) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {

        }

        @Override
        public void onServerFailure(String e) {

        }
    });

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
            return (String) PreUtils.getParam(FollowUpMessageDetailActivity.this, "uuid", "");
        }

        @Override
        public String getUserType() {
            return "1";
        }

        @Override
        public void LoadFollowUpDialogue(ResultModel<List<FollowUpMessageDetaild>> model) {

            List<FollowUpMessageDetaild>  list2=new ArrayList<>();
            for(int i=0;i<model.getData().size();i++){

                switch (model.getData().get(i).getConsultation_type()){
                    //是1的话的就加载随访对话数据,2是提醒，3是患教
                    case 1:
                        list2.add(model.getData().get(i));
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }

            }


//            Toast.makeText(FollowUpMessageDetailActivity.this, ""+model.getData().size(), Toast.LENGTH_SHORT).show();
            ListItemAdapter listItemAdapter = new ListItemAdapter(FollowUpMessageDetailActivity.this, FollowUpMessageDetailActivity.this, list2);
            lvFollowUpDetail.setAdapter(listItemAdapter);
            //监听listview的滑动事件，隐藏软键盘和发送框
            lvFollowUpDetail.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                    llMessageSend.setVisibility(View.INVISIBLE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                    }

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                }
            });
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(FollowUpMessageDetailActivity.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(FollowUpMessageDetailActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    });
    //监听软键盘的显示与隐藏


    @Override
    protected void onResume() {
        super.onResume();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mFollowUpDialoguePresenter.getFollowUpDialogue();
                //为了判断是否绑定随访
                mHomePresenter.getDoctorTeamInfo();
            }
        });
        getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

                if (bottom != 0 && oldBottom != 0 && oldBottom - bottom > keyHeight) {
                    llMessageSend.setVisibility(View.INVISIBLE);
                } else {
                    //当发送输入框显示时，让输入框自动获取焦点
                    if (llMessageSend.getVisibility() == View.VISIBLE) {
                        etReplyPatient.setFocusable(true);
                        etReplyPatient.setFocusableInTouchMode(true);
                        etReplyPatient.setText("");
                        etReplyPatient.requestFocus();
                    }
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick(R.id.tv_condition_quiz)
    public void onViewClicked() {
        startActivity(new Intent(FollowUpMessageDetailActivity.this,QuizActivity.class));
    }

}
