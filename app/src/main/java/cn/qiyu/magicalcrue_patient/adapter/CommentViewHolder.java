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
 */

public class CommentViewHolder extends RecyclerView.ViewHolder {



   private Comment comment;
    @Bind({R.id.tv_comment_name,R.id.tv_comment_content})
    TextView [] textView;
    private View view;
    public CommentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        view=itemView;
    }

    void setItem(Comment item) {
        this.comment = item;
    }

    //刷新
    void refreshView() {
        if(comment.getUser_role()==1)
                textView[0].setTextColor(Color.parseColor("#f78826"));
        else
            textView[0].setTextColor(Color.parseColor("#58BECB"));

            textView[0].setText(comment.getUserName()+":");
        textView[1].setText(comment.getContent());
    }
}
