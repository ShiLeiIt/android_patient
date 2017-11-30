package cn.qiyu.magicalcrue_patient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

import cn.qiyu.magicalcrue_patient.fragment.AllScaleFragment;
import cn.qiyu.magicalcrue_patient.fragment.FiScaleFragment;
import cn.qiyu.magicalcrue_patient.fragment.ToFiScaleFragment;

/**
 * Created by admin on 2017/11/25.
 */

public class TabAdapter extends FragmentPagerAdapter {
//    定义顶部导航栏有几个
    private String[] title=new String[]{"待填写","已填写","全部"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

//    对顶部导航的item分配
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ToFiScaleFragment();
        } else if (position == 1) {
            return new FiScaleFragment();
        } else if (position == 2) {
            return new AllScaleFragment();
        }else {
            return null;
        }
    }
    @Override
    public int getCount() {
        return title.length;
    }

    //设置tablayout标题
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
