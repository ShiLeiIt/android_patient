package cn.qiyu.magicalcrue_patient.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.ScaleTitleBean;

/**
 * Created by shilei on 2017/12/2.
 * 量表详情适配器
 */

public class ScaleDetailsAdapter extends BaseAdapter {

    private Context mContext;
    private List<ScaleTitleBean> mlist;

    public ScaleDetailsAdapter(Context context, List<ScaleTitleBean> mlist) {
        mContext = context;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return null == mlist ? 0: mlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.recyclerview_item_option, null);
            viewHolder.mtextview = (TextView) convertView.findViewById(R.id.tv_question_title);
            viewHolder.linearLayout = (LinearLayout) convertView.findViewById(R.id.ll_question_option_container);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        refreshView(position, viewHolder);
        return convertView;
    }


    //刷新
    void refreshView(int num, final ViewHolder viewHolder) {
        final ScaleTitleBean mModel = mlist.get(num);
        String type = "";
        viewHolder.linearLayout.removeAllViews();
        for (int position = 0; position < mModel.getOptionsList().size(); position++) {
            CheckBox checkBox = new CheckBox(mContext);
            checkBox.setButtonDrawable(mContext.getResources().getDrawable(R.drawable.selector_choose));
            checkBox.setText(mModel.getOptionsList().get(position).getContent());
            checkBox.setTextColor(mContext.getResources().getColor(R.color.app_gray));
            checkBox.setId(View.generateViewId());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 20, 0, 0);
            checkBox.setLayoutParams(layoutParams);

            checkBox.setChecked(mModel.getOptionsList().get(position).isChecked());
            viewHolder.linearLayout.addView(checkBox);

            switch (mModel.getQuestionType()) {
                case "radio":
                    type = "（单选）";
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                            for (int index = 0; index < viewHolder.linearLayout.getChildCount(); index++) {
                                if (viewHolder.linearLayout.getChildAt(index).getId() == compoundButton.getId()) {
                                    Log.e("rg", "aaaa" + index + "---" + compoundButton.getId() + "-----" + viewHolder.linearLayout.getChildAt(index).getId());
                                    mModel.getOptionsList().get(index).setChecked(true);
                                } else {
                                    Log.e("rg", index + "---" + compoundButton.getId() + "-----" + viewHolder.linearLayout.getChildAt(index).getId());
                                    mModel.getOptionsList().get(index).setChecked(false);

                                }
                            }
                            notifyDataSetChanged();
                        }
                    });

                    break;

                case "checkbox":
                    type = "（多选）";
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                            for (int index = 0; index < viewHolder.linearLayout.getChildCount(); index++) {
                                if (viewHolder.linearLayout.getChildAt(index).getId() == compoundButton.getId()) {
                                    Log.e("rg", "bbbbbb" + index + "---" + compoundButton.getId() + "-----" + viewHolder.linearLayout.getChildAt(index).getId());
                                    mModel.getOptionsList().get(index).setChecked(isChecked);
                                    notifyDataSetChanged();
                                    break;
                                }
                            }
                        }
                    });
                    break;

                default:
                    viewHolder.linearLayout.setVisibility(View.VISIBLE);
                    viewHolder.linearLayout.removeAllViews();
                    type = "(描述)";
                    final EditText editText = new EditText(mContext);
                    editText.setBackgroundResource(R.drawable.edit_scale_detail);
                    editText.setTextColor(mContext.getResources().getColor(R.color.app_gray));
                    if (!TextUtils.isEmpty(mModel.getResult())) {
                        editText.setText(mModel.getResult());
                    }
                    //editText.clearFocus(); //失去焦点
                    editText.requestFocus();
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            mModel.setResult(editText.getText().toString());
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });
                    viewHolder.linearLayout.addView(editText);
                    break;
            }

            viewHolder.mtextview.setText((num + 1) + "、" + mModel.getContent().toString() + type);

        }
    }


    static class ViewHolder {
        TextView mtextview;
        LinearLayout linearLayout;
    }
}