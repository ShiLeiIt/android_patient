package cn.qiyu.magicalcrue_patient.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.view.NoScrollGridView;


/**
 * Created by Administrator on 2017/12/21.
 * 用药方案适配器
 */

public class ListPharmacyItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<PharmacyBean> items;
    private Activity activity;
    private PharmacyBean itemEntity;
    private ViewHolder holder;


    public ListPharmacyItemAdapter(Context ctx, Activity activity, List<PharmacyBean> items) {
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
            //药名
            holder.tv_drug_name = (TextView) convertView
                    .findViewById(R.id.tv_discharge_hospital_address);
            //剂量
            holder.dosage = (TextView) convertView
                    .findViewById(R.id.tv_discharge_doctor_name);
            //方式
            holder.tv_treatment_for = (TextView) convertView
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

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
//        String date=dateFormat.format(itemEntity.getCreate_time());


        String createTime = itemEntity.getCreate_time();
        String substringTime = createTime.substring(0, 10);


        holder.tv_date.setText(substringTime+"  "+itemEntity.getUsaged());

        //药名
        holder.tv_drug_name.setText("药名：  "+itemEntity.getDrug_name());
        //方式
        holder.tv_treatment_for.setText("方式：  "+itemEntity.getUsaged());
        //剂量
        holder.dosage.setText("剂量：  "+itemEntity.getAmount());
        //备注
        if (TextUtils.isEmpty(itemEntity.getRemarks())) {
            holder.tv_context.setText("暂无");
        }else{
            holder.tv_context.setText(itemEntity.getRemarks());
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
        private TextView tv_drug_name;
        private TextView tv_treatment_for;
        private TextView dosage;
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
