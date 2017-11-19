package cn.qiyu.magicalcrue_patient.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import cn.qiyu.magicalcrue_patient.R;

/**
 * Created by ShiLei on 2017/11/19
 */
public class SelectPicPopupWindow extends PopupWindow {
	public LinearLayout ll_photo;
	public TextView tv_photo;
	public TextView tv_local_photo;
	public TextView tv_cancel;
	public TextView tv_title;
	public SelectPicPopupWindow(Activity context, OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ll_photo = (LinearLayout) inflater.inflate(R.layout.pop_photo, null);
		tv_photo = (TextView) ll_photo.findViewById(R.id.tv_photo);
		tv_local_photo = (TextView) ll_photo.findViewById(R.id.tv_local_photo);
		tv_cancel = (TextView) ll_photo.findViewById(R.id.tv_cancel);
		// 取消按钮
		tv_cancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 销毁弹出框
				dismiss();
			}
		});

		// 设置按钮监听
		tv_photo.setOnClickListener(itemsOnClick);
		tv_local_photo.setOnClickListener(itemsOnClick);
		// 设置SelectPicPopupWindow的View
		this.setContentView(ll_photo);
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(LayoutParams.MATCH_PARENT);
		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		// 设置SelectPicPopupWindow弹出窗体动画效果
		// this.setAnimationStyle(R.style.AnimBottom);
		// 实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		// 设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);
		// mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框

	}
}
