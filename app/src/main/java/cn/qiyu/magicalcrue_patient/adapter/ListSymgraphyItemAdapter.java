package cn.qiyu.magicalcrue_patient.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.SymptomatographyBean;
import cn.qiyu.magicalcrue_patient.view.NoScrollGridView;


/**
 * Created by Administrator on 2017/12/21.
 * 身体症状记录
 */

public class ListSymgraphyItemAdapter extends BaseAdapter {

    private Context mContext;
    private List<SymptomatographyBean> items;
    private Activity activity;
    private SymptomatographyBean itemEntity;
    private ViewHolder holder;


    public ListSymgraphyItemAdapter(Context ctx, Activity activity, List<SymptomatographyBean> items) {
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
            //报告单类型
            holder.tv_report_form = (TextView) convertView
                    .findViewById(R.id.tv_discharge_hospital_address);
            //
            holder.dosage = (TextView) convertView
                    .findViewById(R.id.tv_discharge_doctor_name);
            //
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




        String createTime = itemEntity.getCreate_time();
        String substringTime = createTime.substring(0, 10);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String date=dateFormat.format(now);
        String nian = date.substring(0, 4) + "年";
        String yue = date.substring(5, 7) + "月";
        String ri = date.substring(8, 10) + "日";

        holder.tv_date.setText(nian+yue+ri+"  "+"身体症状记录");
        //报告单类型
        holder.tv_report_form.setText("症状名称：  "+itemEntity.getSymptom_code());
        holder.dosage.setVisibility(View.GONE);
        holder.tv_treatment_for.setVisibility(View.GONE);

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
        private TextView tv_report_form;
        private TextView tv_context;
        private TextView dosage;
        private TextView tv_treatment_for;
        private NoScrollGridView gridview;
    }




}
