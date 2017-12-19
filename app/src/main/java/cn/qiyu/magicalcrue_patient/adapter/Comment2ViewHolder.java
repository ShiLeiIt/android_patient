package cn.qiyu.magicalcrue_patient.adapter;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.Comment;


/**
 * Created by Administrator on 2017/12/6.
 * 门诊资料医生回复
 */

public class Comment2ViewHolder extends RecyclerView.ViewHolder {
        private Comment comment;
        @Bind({R.id.tv_comment_name2,R.id.tv_comment_content2})
        TextView [] textView;

        public Comment2ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
        void setItem(Comment item) {
            this.comment = item;
        }
        //刷新
        void refreshView() {
            textView[0].setText("医生回复：（"+comment.getUserName()+"）");
            textView[1].setText(comment.getContent());
        }
}
