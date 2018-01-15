package cn.qiyu.magicalcrue_patient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import butterknife.Bind;
import butterknife.ButterKnife;

import cn.qiyu.magicalcrue_patient.R;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * Created by zheng on 2017/11/27.
 * 图片查看器
 */

public class PhotoFragment extends Fragment {

    @Bind(R.id.help_center_loading_prgbar)
    ProgressBar helpCenterLoadingPrgbar;
    private String url;
    private PhotoView mPhotoView;

    /**
     * 获取这个fragment需要展示图片的url
     *
     * @param url
     * @return
     */
    public static PhotoFragment newInstance(String url) {
        PhotoFragment fragment = new PhotoFragment();
        Bundle args = new Bundle();
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getArguments().getString("url");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_img, container, false);
        ButterKnife.bind(this, view);
        helpCenterLoadingPrgbar.setVisibility(View.VISIBLE);
        mPhotoView = (PhotoView) view.findViewById(R.id.pv_image);
        //设置缩放类型，默认ScaleType.CENTER（可以不设置）
        mPhotoView.setScaleType(ImageView.ScaleType.CENTER);
        mPhotoView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return true;
            }
        });
        mPhotoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                getActivity().finish();
            }
        });
        //初始化
     /*   final ObjectAnimator anim = ObjectAnimator.ofInt(mPhotoView, "ImageLevel", 0, 10000);
        anim.setDuration(500);
        anim.setRepeatCount(ObjectAnimator.INFINITE);
        anim.start();*/
        Glide.with(getContext())
                .load(url)
                //.placeholder(R.drawable.rotate_pro)//加载过程中图片未显示时显示的本地图片
                .error(R.drawable.banner)//加载异常时显示的图片
                //.centerCrop()//
                .crossFade(10)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String s, Target<GlideDrawable> target, boolean b) {
                        helpCenterLoadingPrgbar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getContext(), "图片加载失败", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable glideDrawable, String s, Target<GlideDrawable> target, boolean b, boolean b1) {
                        helpCenterLoadingPrgbar.setVisibility(View.INVISIBLE);
                        return false;
                    }
                })
                //图片图填充ImageView设置的大小
                .fitCenter()//缩放图像测量出来等于或小于ImageView的边界范围,该图像将会完全显示
                .into(mPhotoView);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
