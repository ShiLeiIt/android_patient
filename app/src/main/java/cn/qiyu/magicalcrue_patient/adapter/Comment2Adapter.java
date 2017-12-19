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

public class Comment2Adapter extends  RecyclerView.Adapter<Comment2ViewHolder> {

    private List<Comment> comments;
    public Comment2Adapter(List<Comment> comments){
        this.comments=comments;
    }

    @Override
    public Comment2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new Comment2ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_comment2, null));
    }
    @Override
    public void onBindViewHolder(Comment2ViewHolder holder, int position) {
        holder.setItem(comments.get(position));
        holder.refreshView();
    }

    @Override
    public int getItemCount() {
        return comments.size()==0? 0:comments.size();
    }
}
