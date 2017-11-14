package cn.qiyu.magicalcrue_patient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.qiyu.magicalcrue_patient.R;

/**
 * Created by Administrator on 2017/11/13.
 */

public class VisitFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_visit, container, false);
    }
}
