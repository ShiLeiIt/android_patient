package cn.qiyu.magicalcrue_patient.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
import cn.qiyu.magicalcrue_patient.model.CreateRemindBean;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.HomeBannerBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.JsonParser;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.utils.TimeUtils;
import cn.qiyu.magicalcrue_patient.visit.FollowUpDialoguePresenter;
import cn.qiyu.magicalcrue_patient.visit.FollowUpDialogueView;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindDetailsView;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindListPresenter;


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
    @Bind(R.id.btn_voice_text)
    ImageView mBtnVoiceText;
    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;
    private String mErrorCode;
    private String mRemindUuid;
    private Toast mToast;
    // 语音听写UI
    private RecognizerDialog mIatDialog;
    private boolean mTranslateEnable = false;
    // 用HashMap存储听写结果
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_up_message_detail);
        ButterKnife.bind(this);
        init();

        //获取屏幕高度
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        //阀值设置为屏幕高度的1/3
        keyHeight = screenHeight / 3;
        mInformationPresenter.getFollowUpMsgRead();

    }

    private void init() {
        //初始化语音转文字
        SpeechUtility.createUtility(this, SpeechConstant.APPID+"=5a716a76");
    }
    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            if (code != ErrorCode.SUCCESS) {
                showTip("初始化失败，错误码：" + code);
            }
        }
    };
    private void showTip(final String str) {
        mToast.setText(str);
        mToast.show();
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
            return (String) PreUtils.getParam(FollowUpMessageDetailActivity.this, "patientuuid", "0");
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

        }

        @Override
        public void onServerFailure(String e) {

        }
    });


    //消息已读
    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationFollowUpRdView() {
        @Override
        public String getUserUuid() {
            return (String) PreUtils.getParam(FollowUpMessageDetailActivity.this, "uuid", "0");
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
//            Toast.makeText(FollowUpMessageDetailActivity.this, ""+model.getData().size(), Toast.LENGTH_SHORT).show();
            ListItemAdapter listItemAdapter = new ListItemAdapter(FollowUpMessageDetailActivity.this, FollowUpMessageDetailActivity.this, model.getData());
            listItemAdapter.setonSurplusDeleteListenerListener(new ListItemAdapter.onSurplusDeleteListener() {
                @Override
                public void OnItemImportanceListener(String id) {
                    Intent intent = new Intent(FollowUpMessageDetailActivity.this, BannerDetailActivity.class);
                    intent.putExtra("url", id);
                    startActivity(intent);
                }
            });

            listItemAdapter.setonSurplusRemindListenerListener(new ListItemAdapter.onRemindListener() {
                @Override
                public void OnItemRemindListener(String id) {
                    mRemindUuid = id;
                    mDetailsPresenter.getVisitRemindDetails();
                }
            });

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

    @OnClick({R.id.tv_condition_quiz,R.id.btn_voice_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_condition_quiz:
                startActivity(new Intent(FollowUpMessageDetailActivity.this, QuizActivity.class));
                break;
            case R.id.btn_voice_text:
                mIatDialog = new RecognizerDialog(FollowUpMessageDetailActivity.this, mInitListener);
                mIatDialog.setListener(mRecognizerDialogListener);
                mIatDialog.show();
                //获取字体所在的控件，设置为"",隐藏字体，
                TextView txt = (TextView)mIatDialog.getWindow().getDecorView().findViewWithTag("textlink");
                txt.setText("");
                break;
        }

    }

    VisitRemindListPresenter mDetailsPresenter = new VisitRemindListPresenter(new VisitRemindDetailsView() {
        @Override
        public String getRemindUuid() {
            return mRemindUuid;
        }

        @Override
        public void LoadVisiteRemindDetails(ResultModel<CreateRemindBean> model) {
            Intent intent = new Intent(FollowUpMessageDetailActivity.this, RemindDetailsActivity.class);
            intent.putExtra("remindUuid", model.getData().getUuid());
            intent.putExtra("remindTimeWeek", TimeUtils.getWeekStr(model.getData().getCreate_time()));
            intent.putExtra("fromFollowUp", "0");
            startActivity(intent);

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
    /**
     * 听写UI监听器
     */
    private RecognizerDialogListener mRecognizerDialogListener = new RecognizerDialogListener() {
        public void onResult(RecognizerResult results, boolean isLast) {
            if( mTranslateEnable ){
                printTransResult( results );
            }
            else{
                printResult(results);
            }

        }

        /**
         * 识别回调错误.
         */
        public void onError(SpeechError error) {
//            if(mTranslateEnable && error.getErrorCode() == 14002) {
//                showTip( error.getPlainDescription(true)+"\n请确认是否已开通翻译功能" );
//            } else {
//                showTip(error.getPlainDescription(true));
//            }
        }

    };
    private void printResult(RecognizerResult results) {
        String text = JsonParser.parseIatResult(results.getResultString());

        String sn = null;
        // 读取json结果中的sn字段
        try {
            JSONObject resultJson = new JSONObject(results.getResultString());
            sn = resultJson.optString("sn");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mIatResults.put(sn, text);

        StringBuffer resultBuffer = new StringBuffer();
        for (String key : mIatResults.keySet()) {
            resultBuffer.append(mIatResults.get(key));
        }

        etReplyPatient.setText(resultBuffer.toString());
        Toast.makeText(this, ""+resultBuffer.toString(), Toast.LENGTH_SHORT).show();
        etReplyPatient.setSelection(etReplyPatient.length());
    }
    private void printTransResult (RecognizerResult results) {
        String trans  = JsonParser.parseTransResult(results.getResultString(),"dst");
        String oris = JsonParser.parseTransResult(results.getResultString(),"src");

        if( TextUtils.isEmpty(trans)||TextUtils.isEmpty(oris) ){
            showTip( "解析结果失败，请确认是否已开通翻译功能。" );
        }else{
            etReplyPatient.setText( "原始语言:\n"+oris+"\n目标语言:\n"+trans );
        }

    }


}
