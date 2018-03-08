package cn.qiyu.magicalcrue_patient.adapter;

/**
 * Created by Administrator on 2017/12/5.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.DisplayHelper;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.view.NoScrollGridView;
import cn.qiyu.magicalcrue_patient.visit.CommentVisitDialoguePresenter;
import cn.qiyu.magicalcrue_patient.visit.CommentVisitDialogueView;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 随访对话的数据适配器
 *
 * @author Administrator
 */
public class ListItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<FollowUpMessageDetaild> items;
    private Activity activity;
    private FollowUpMessageDetaild itemEntity;
    private EditText reply_patient;
    private ViewHolder holder;
    private List<Comment> comments1;

    //对话UUID
    private String commentUUid;
    private int indexrefresh;

    public ListItemAdapter(Context ctx, Activity activity, List<FollowUpMessageDetaild> items) {
        this.items = items;
        this.mContext = ctx;
        this.items = items;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_list, null);
            //头像
            holder.iv_avatar = (CircleImageView) convertView
                    .findViewById(R.id.iv_avatar);
            //提问人姓名
            holder.tv_title = (TextView) convertView
                    .findViewById(R.id.tv_title);
            //提问内容
            holder.tv_content = (TextView) convertView
                    .findViewById(R.id.tv_content);
            //提问人与患者关系
            holder.tv_relation = (TextView) convertView
                    .findViewById(R.id.tv_patient_relation);
            //提问时间
            holder.tv_create_time = (TextView) convertView
                    .findViewById(R.id.tv_message_establish_time);
            holder.gridview = (NoScrollGridView) convertView
                    .findViewById(R.id.grid_view_item);

            //提醒和患教资料
            holder.iv_surplus=(ImageView)convertView.findViewById(R.id.iv_surplus);
            holder.surplus_centext=(TextView)convertView.findViewById(R.id.tv_context_surplus);
            holder.surplus_title=(TextView)convertView.findViewById(R.id.tv_title_surplus);
            //提醒
            holder.ll_surplus=(LinearLayout)convertView.findViewById(R.id.ll_surplus);


            //回复展示
            holder.recyclerView = (RecyclerView) convertView.findViewById(R.id.rv_comment);
            convertView.setTag(holder);



        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //实体类
        itemEntity = items.get(position);
        //判断发起对话的人的角色
        if(itemEntity.getUserType()==1){
            //患者属性
            DisplayHelper.loadGlide(mContext, ApiService.GET_IMAGE_ICON+ itemEntity.getPhotoPath(), holder.iv_avatar);

            //回复者姓名
            holder.tv_title.setText(itemEntity.getUser_name());
            //回复者角色
            holder.tv_relation.setText(itemEntity.getRelationshipName());
        }else {
            //加载医生头像
            DisplayHelper.loadGlide(mContext, ApiService.GET_IMAGE_ICON+ itemEntity.getDoctor_photo_path(), holder.iv_avatar);
            //回复者角色
            holder.tv_relation.setText("医生");
            //回复者姓名
            holder.tv_title.setText(itemEntity.getDoctor_name());
        }
//        //回复title
//        holder.tv_title.setText("  "+itemEntity.getUser_name());
        //回复内容
        holder.tv_content.setText(itemEntity.getComplaint());
//        if (itemEntity.getConsultation_type()==1) {
////            holder.gridview.setVisibility(View.GONE);
//
//        } else if (itemEntity.getConsultation_type() == 2) {
//            //医生发送提醒过到随访界面隐藏
//            convertView.setVisibility(View.GONE);
//        } else {
//            convertView.setVisibility(View.GONE);
////            holder.tv_content.setText("333");
//        }
        //回复时间
        holder.tv_create_time.setText(itemEntity.getCreate_time());
//        //回复者姓名
//        holder.tv_relation.setText(itemEntity.getRelationshipName());
        // 回复列表

        //回复按钮单击事件
        convertView.findViewById(R.id.ll_message_reply_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                commentUUid=items.get(position).getUuid();
                indexrefresh = position;
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//                //将包含输入框的布局显示出来
                LinearLayout   llSend = (LinearLayout)activity.findViewById(R.id.ll_message_send);
                llSend.setVisibility(View.VISIBLE);

//                //发送按钮的点击事件，处理
                activity.findViewById(R.id.btn_send_message).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        reply_patient = (EditText) activity.findViewById(R.id.et_reply_patient);
                        if(reply_patient.getText().toString().equals(""))
                            Toast.makeText(mContext, "请输入字符", Toast.LENGTH_SHORT).show();
                        else
                            mCommentVisitDialoguePresenter.getCommentVisitDialogue();
                    }
                });
            }
        });


        //刷新部分的列表
        holder.recyclerView.setAdapter(new CommentAdapter(itemEntity.getCommentList()));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        //设置评论区不可滑动
        holder.recyclerView.setNestedScrollingEnabled(false);
        //显示加载容器

        //判断图片集合是否为空
        if (itemEntity.getEnclosureList().size()==0) {
            //隐藏装载容器
            holder.gridview.setVisibility(View.GONE);
        } else {

            holder.gridview.setVisibility(View.VISIBLE);
            holder.gridview.setAdapter(new GridItemAdapter(mContext, itemEntity.getEnclosureList()));
        }

        switch (itemEntity.getConsultation_type()){
            case 1:
                holder.ll_surplus.setVisibility(View.GONE);
                if(itemEntity.getEnclosureList().size()==0){
                    //隐藏装载容器
                    holder.gridview.setVisibility(View.GONE);
                }else {
                    //显示加载容器

                    holder.gridview.setVisibility(View.VISIBLE);
                    holder.gridview.setAdapter(new GridItemAdapter(mContext, itemEntity.getEnclosureList()));
                }

                break;
            //提醒
            case 2:
                holder.iv_surplus.setImageResource(R.drawable.surplus2);
                holder.ll_surplus.setVisibility(View.VISIBLE);
                holder.surplus_title.setText(itemEntity.getEventInfoBean().getEvent_name());
                holder.surplus_centext.setText(itemEntity.getEventInfoBean().getEvent_time()+itemEntity.getEventInfoBean().getEvent_detail());
                holder.gridview.setVisibility(View.GONE);
                holder.ll_surplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onRemindListener.OnItemRemindListener(items.get(position).getEventInfoBean().getUuid());
                    }
                });


                break;
            //患教
            case 3:
                holder.iv_surplus.setImageResource(R.drawable.surplus3);
                holder.ll_surplus.setVisibility(View.VISIBLE);
                holder.surplus_title.setText(itemEntity.getCourseInfoBean().getTitle());
                holder.surplus_centext.setText(itemEntity.getCourseInfoBean().getContent());
                holder.gridview.setVisibility(View.GONE);

                holder.ll_surplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnSurplusListener.OnItemImportanceListener(items.get(position).getCourseInfoBean().getUrl());
                    }
                });
                break;
        }


        return convertView;
    }
    /**
     * 进入查看患教详情
     */
    public interface onSurplusDeleteListener {
        void OnItemImportanceListener(String id);
    }

    private onSurplusDeleteListener mOnSurplusListener;

    public void setonSurplusDeleteListenerListener(onSurplusDeleteListener mOnItemDeleteListener) {
        this.mOnSurplusListener = mOnItemDeleteListener;
    }



    /**
     * 进入查看提醒详情
     */
    public interface onRemindListener {
        void OnItemRemindListener(String id);
    }

    private onRemindListener onRemindListener;

    public void setonSurplusRemindListenerListener(onRemindListener onRemindDeleteListener) {
        this.onRemindListener = onRemindDeleteListener;
    }

    //局部刷新评论区
    private void updateItem(int index, List<Comment> list) {
        ListView list_message = (ListView) activity.findViewById(R.id.lv_follow_up_Detail);
        int visibleFirstPosi = list_message.getFirstVisiblePosition();
        int visibleLastPosi = list_message.getLastVisiblePosition();
        if (index >= visibleFirstPosi && index <= visibleLastPosi) {
            View view = list_message.getChildAt(index - visibleFirstPosi);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_comment);
            recyclerView.setAdapter(new CommentAdapter(list));
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));


        }
    }


    /**
     * listview组件复用，防止“卡顿”
     *
     * @author Administrator
     */
    static class ViewHolder {
        private RecyclerView recyclerView;
        private CircleImageView iv_avatar;
        private TextView tv_title;
        private TextView tv_content;
        private TextView tv_relation;
        private TextView tv_create_time;
        private NoScrollGridView gridview;
        private LinearLayout ll_surplus;
        private TextView surplus_title;
        private TextView surplus_centext;
        private ImageView iv_surplus;
    }


    CommentVisitDialoguePresenter mCommentVisitDialoguePresenter = new CommentVisitDialoguePresenter(new CommentVisitDialogueView() {
        @Override
        public String getUserUuid() {
            return (String) PreUtils.getParam(mContext, "uuid", "0");
        }

        @Override
        public String getConsultationId() {
            Log.i("commentUUid==", commentUUid);
            return commentUUid;
        }

        @Override
        public String getUserRole() {
            return "1";
        }

        @Override
        public String getContent() {
            return reply_patient.getText().toString();
        }

        @Override
        public String getParentId() {
            return "";
        }

        @Override
        public String getType() {
            return "1";
        }

        @Override
        public void LoadCommentVisitDialogue(ResultModel model) {
//            Toast.makeText(mContext, "" + model.getMessage(), Toast.LENGTH_SHORT).show();
            mCommentVisitDialoguePresenter.getCommentList();
        }


        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPageCount() {
            return "100";
        }

        @Override
        public void LoadCommentList(ResultModel<List<Comment>> model) {
            comments1 = model.getData();
        //发送回复成功之后隐藏软键盘
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
            updateItem(indexrefresh, model.getData());
        //更新items  集合中被评论的 评论集合
            items.get(indexrefresh).setCommentList(model.getData());

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(mContext, "" + model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Log.i("消息", e);
            Toast.makeText(mContext, "" + e, Toast.LENGTH_SHORT).show();
        }
    });

}