package cn.qiyu.magicalcrue_patient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.qiyu.magicalcrue_patient.fragment.PhotoFragment;
import cn.qiyu.magicalcrue_patient.model.EncloSure;


/**
 * Created by zheng on 2017/11/27.
 */

public class PhotoPagerAdapter extends FragmentPagerAdapter {

    private final List<EncloSure> urlList;

    public PhotoPagerAdapter(FragmentManager fm, List<EncloSure> urlList) {
        super(fm);
        this.urlList=urlList;
    }



    @Override
    public Fragment getItem(int position) {
        return PhotoFragment.newInstance(urlList.get(position).getFilePath());
    }

    @Override
    public int getCount() {
        return urlList.size();
    }
}
