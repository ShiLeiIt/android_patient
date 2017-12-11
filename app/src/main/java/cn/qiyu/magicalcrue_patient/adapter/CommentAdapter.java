package cn.qiyu.magicalcrue_patient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.Comment;


/**
 * Created by Administrator on 2017/12/6.
 */

public class CommentAdapter extends  RecyclerView.Adapter<CommentViewHolder> {

    private List<Comment> comments;

    public CommentAdapter (List<Comment> comments){
        this.comments=comments;

    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_comment, null));
    }


    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.setItem(comments.get(position));
        holder.refreshView();
    }

    @Override
    public int getItemCount() {
        return comments.size()==0? 0:comments.size();
    }
}
