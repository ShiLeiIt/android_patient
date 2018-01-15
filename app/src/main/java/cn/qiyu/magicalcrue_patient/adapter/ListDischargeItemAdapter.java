package cn.qiyu.magicalcrue_patient.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.List;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.view.NoScrollGridView;


/**
 * Created by Administrator on 2017/12/18.
 * 门诊信息，与出院小结数据适配器
 */

public class ListDischargeItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<DischargeBean> items;
    private Activity activity;
    private DischargeBean itemEntity;
    private EditText reply_patient;
    private ViewHolder holder;
    private List<Comment> comments1;
    //对话UUID
    private  String commentUUid;
    private int indexrefresh;
    private String mIsOutPatient;


    public ListDischargeItemAdapter(Context ctx,Activity activity, List<DischargeBean> items,String isOutPatient) {
        this.items=items;
        this.mContext = ctx;
        this.items = items;
        this.activity=activity;
        this.mIsOutPatient = isOutPatient;

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
            convertView = View.inflate(mContext, R.layout.list_discharge, null);
            //创建时间
           holder.tv_create_date= (TextView) convertView
                    .findViewById(R.id.tv_create_date);

            //门诊时间
            holder.tv_date = (TextView) convertView
                    .findViewById(R.id.tv_discharge_date);
            //医院地址
            holder.tv_hospital = (TextView) convertView
                    .findViewById(R.id.tv_discharge_hospital_address);
            //医生姓名
            holder.tv_doctor_name = (TextView) convertView
                    .findViewById(R.id.tv_discharge_doctor_name);
            //科室
            holder.tv_administrative = (TextView) convertView
                    .findViewById(R.id.tv_discharge_administrative);
            //备注
            holder.tv_context = (TextView) convertView
                    .findViewById(R.id.tv_discharge_context);
            //图片加载
            holder.gridview = (NoScrollGridView) convertView
                    .findViewById(R.id.nv_discharge_photo);
            convertView.setTag(holder);
            //回复展示
            holder.recyclerView=(RecyclerView)convertView.findViewById(R.id.ry_comment_discharge);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //实体类
        itemEntity = items.get(position);
        // 时间

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date=dateFormat.format(itemEntity.getBe_hospitalized_date());

        String createTime = itemEntity.getCreate_time();
        String substring = createTime.substring(0, 16);

        if (mIsOutPatient.equals("outPatient")) {
            holder.tv_create_date.setText(substring);
        } else {
            holder.tv_create_date.setText(substring);
        }
        //门诊时间
        holder.tv_date.setText("门诊时间：  "+date);
        //地址
        holder.tv_hospital.setText("医院：  "+itemEntity.getHospitalName());
        //科室
        holder.tv_administrative.setText("科室：  "+itemEntity.getOffice_name());
        //医生姓名
        holder.tv_doctor_name.setText("医师：  "+itemEntity.getDoctor_name());
        //备注
        if (TextUtils.isEmpty(itemEntity.getSummary())) {
            holder.tv_context.setText("暂无");
        }else{
            holder.tv_context.setText(itemEntity.getSummary());
        }

        // 回复列表
        //刷新部分的列表
        holder.recyclerView.setAdapter(new Comment2Adapter(itemEntity.getCommentList()));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        //设置评论区不可滑动
        holder.recyclerView.setNestedScrollingEnabled(false);
        //判断图片集合是否为空
        if(itemEntity.getImglist().size()==0){
            //隐藏装载容器
            holder.gridview.setVisibility(View.GONE);
        }else {
            //显示加载容器
            holder.gridview.setVisibility(View.VISIBLE);
            holder.gridview.setAdapter(new GridItemAdapter(mContext, itemEntity.getImglist()));
        }
        //回复按钮单击事件
//        convertView.findViewById(R.id.ll_message_reply_discharge).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                commentUUid=items.get(position).getUuid();
//                indexrefresh = position;
//                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//                //将包含输入框的布局显示出来
//                LinearLayout llSend = (LinearLayout)activity.findViewById(R.id.ll_discharge_message_send);
//                llSend.setVisibility(View.VISIBLE);
//                //发送按钮的点击事件，处理
//                activity.findViewById(R.id.btn_discharge_send_message).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        reply_patient = (EditText) activity.findViewById(R.id.et_discharge_reply_patient);
//                        if(reply_patient.getText().toString().equals(""))
//                            Toast.makeText(mContext, "请输入字符", Toast.LENGTH_SHORT).show();
//                        else {
//                            casePresenter.setmedicalrecordcomment();
//                        }
//                    }
//                });
//            }
//        });

        return convertView;
    }




    /**
     * listview组件复用，防止“卡顿”
     *
     * @author Administrator
     *
     */
    static class  ViewHolder {
        private RecyclerView recyclerView;
        private TextView tv_date;
        private TextView tv_create_date;
        private TextView tv_hospital;
        private TextView tv_administrative;
        private TextView tv_doctor_name;
        private TextView tv_context;
        private NoScrollGridView gridview;
    }
    /**
     *
     *
     *
     *
     *
     */



}
