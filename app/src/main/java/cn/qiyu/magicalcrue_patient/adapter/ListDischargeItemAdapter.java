package cn.qiyu.magicalcrue_patient.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.view.NoScrollGridView;


/**
 * Created by Administrator on 2017/12/18.
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

    public ListDischargeItemAdapter(Context ctx,Activity activity, List<DischargeBean> items) {
        this.items=items;
        this.mContext = ctx;
        this.items = items;
        this.activity=activity;
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
       /*     //回复展示
            holder.recyclerView=(RecyclerView)convertView.findViewById(R.id.rv_comment);*/
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //实体类
        itemEntity = items.get(position);
        // 时间

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM月dd日");
        String date=dateFormat.format(itemEntity.getBe_hospitalized_date());

        holder.tv_date.setText(date+"   门诊信息");
        //地址
        holder.tv_hospital.setText("医院：  "+itemEntity.getHospital_name());
        //科室
        holder.tv_administrative.setText("科室：  "+itemEntity.getOffice_name());
        //医生姓名
        holder.tv_doctor_name.setText("医师：  "+itemEntity.getDoctorName());
        //备注
        holder.tv_context.setText(itemEntity.getSummary());
        // 回复列表
        //刷新部分的列表
       // holder.recyclerView.setAdapter(new CommentAdapter(itemEntity.getCommentList()));
       // holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        //设置评论区不可滑动
//        holder.recyclerView.setNestedScrollingEnabled(false);
        //判断图片集合是否为空
        if(itemEntity.getImglist().size()==0){
            //隐藏装载容器
            holder.gridview.setVisibility(View.GONE);
        }else {
            //显示加载容器
            holder.gridview.setVisibility(View.VISIBLE);
            holder.gridview.setAdapter(new GridItemAdapter(mContext, itemEntity.getImglist()));
        }
        return convertView;
    }
/*    //局部刷新评论区
    private void updateItem(int index,List<Comment> list) {
        ListView list_message = (ListView) activity.findViewById(R.id.lv_follow_up_Detail);
        int visibleFirstPosi = list_message.getFirstVisiblePosition();
        int visibleLastPosi = list_message.getLastVisiblePosition();
        if (index >= visibleFirstPosi && index <= visibleLastPosi) {
            View view = list_message.getChildAt(index - visibleFirstPosi);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_comment);
            recyclerView.setAdapter(new CommentAdapter(list));
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        }
    }*/


    /**
     * listview组件复用，防止“卡顿”
     *
     * @author Administrator
     *
     */
    static class  ViewHolder {
        private RecyclerView recyclerView;
        private TextView tv_date;
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
