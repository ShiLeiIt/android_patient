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
 * 全部量表
 */

public class AllScaleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_scale, container, false);
        return view;
    }
}
