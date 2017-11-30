package cn.qiyu.magicalcrue_patient.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.qiyu.magicalcrue_patient.R;

/**
 * Created by ShiLei on 2017/11/30.
 * 已填写量表
 */

public class FiScaleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fi_scale, container, false);
        return view;
    }
}
