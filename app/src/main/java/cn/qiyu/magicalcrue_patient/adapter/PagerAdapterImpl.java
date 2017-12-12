package cn.qiyu.magicalcrue_patient.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.qiyu.magicalcrue_patient.model.EncloSure;
import cn.qiyu.magicalcrue_patient.utils.DisplayHelper;
import cn.qiyu.magicalcrue_patient.view.ZoomImageView;


/**
 * Created by Administrator on 2017/12/6.
 */

public class PagerAdapterImpl extends PagerAdapter {
    private final List<EncloSure> mIvs;
    private final Activity mActivity;

    public PagerAdapterImpl(Activity mainActivity,  List<EncloSure> mIvs) {
        this.mActivity = mainActivity;
        this.mIvs = mIvs;
    }

    @Override
    public int getCount() {
        return mIvs.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ZoomImageView zoomImageView = new ZoomImageView(mActivity);
        DisplayHelper.loadGlide(mActivity,mIvs.get(position).getFilePath(),zoomImageView);
        //zoomImageView.setImageResource(mResId[position]);
        container.addView(zoomImageView);
       // mIvs[position] = zoomImageView;

        return zoomImageView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //container.removeView(mIvs[position]);
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
