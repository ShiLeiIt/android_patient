package cn.qiyu.magicalcrue_patient.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.PatientDataActivity;

/**
 * Created by Administrator on 2017/11/13.
 * 个人信息界面
 */

public class MineFragment extends Fragment {

    private ImageView mIv_patient_back;
    private ImageView mIv_case_history_back;
    private ImageView mIv_order_back;
    private ImageView mIv_collect_back;
    private ImageView mIv_service_back;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_mine, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RelativeLayout view_patient = (RelativeLayout) getActivity().findViewById(R.id.il_patient);
        RelativeLayout view_case = (RelativeLayout) getActivity().findViewById(R.id.il_case_history);
        RelativeLayout view_order = (RelativeLayout) getActivity().findViewById(R.id.il_order);
        RelativeLayout view_collect = (RelativeLayout) getActivity().findViewById(R.id.il_collect);
        RelativeLayout view_service = (RelativeLayout) getActivity().findViewById(R.id.il_service);
        TextView tv_list_patient = (TextView) view_patient.findViewById(R.id.tv_list_item);
        ImageView iv_list_patient = (ImageView) view_patient.findViewById(R.id.iv_list_item);

        tv_list_patient.setText("患者基本资料");
        iv_list_patient.setImageResource(R.drawable.mine_patient);
        TextView tv_list_case = (TextView) view_case.findViewById(R.id.tv_list_item);
        ImageView iv_list_case_icon = (ImageView) view_case.findViewById(R.id.iv_list_item);
        tv_list_case.setText("病历");
        iv_list_case_icon.setImageResource(R.drawable.mine_case_history);
        TextView tv_list_order = (TextView) view_order.findViewById(R.id.tv_list_item);
        ImageView iv_list_order = (ImageView) view_order.findViewById(R.id.iv_list_item);
        tv_list_order.setText("订单");
        iv_list_order.setImageResource(R.drawable.mine_order);
        TextView tv_list_collect = (TextView) view_collect.findViewById(R.id.tv_list_item);
        ImageView iv_list_collect = (ImageView) view_collect.findViewById(R.id.iv_list_item);
        tv_list_collect.setText("收藏");
        iv_list_collect.setImageResource(R.drawable.mine_collect);

        TextView tv_list_service = (TextView) view_service.findViewById(R.id.tv_list_item);
        ImageView iv_list_service = (ImageView) view_service.findViewById(R.id.iv_list_item);
        tv_list_service.setText("客服");
        iv_list_service.setImageResource(R.drawable.mine_service);


        mIv_patient_back = (ImageView) view_patient.findViewById(R.id.iv_list_item_arrows);
        mIv_case_history_back = (ImageView) view_case.findViewById(R.id.iv_list_item_arrows);
        mIv_order_back = (ImageView) view_order.findViewById(R.id.iv_list_item_arrows);
        mIv_collect_back = (ImageView) view_collect.findViewById(R.id.iv_list_item_arrows);
        mIv_service_back = (ImageView) view_service.findViewById(R.id.iv_list_item_arrows);




        mIv_patient_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PatientDataActivity.class));
            }
        });
        mIv_case_history_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIv_order_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIv_collect_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIv_service_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


}
