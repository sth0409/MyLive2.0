package com.example.sth0409.mylive20.Adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sth0409.mylive20.Data.Data_commentsMsg;
import com.example.sth0409.mylive20.Entity.Entity_CommentUser;
import com.example.sth0409.mylive20.Entity.Entity_VideoMsg;
import com.example.sth0409.mylive20.R;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;

import java.util.List;

/**
 * Created by STH0409 on 2016/11/1.
 */

public class Adapter_HeaderFooter extends SuperBaseAdapter<Data_commentsMsg> {
    private Context context;

    public Adapter_HeaderFooter(Context context, List<Data_commentsMsg> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, Data_commentsMsg item, int position) {
        Glide.with(context)
                .load(item.getEntity_commentUser().getAvatarUrl())
                .override(135, 135)
                .centerCrop()
                .into((ImageView) holder.getView(R.id.profile_image));

        holder.setText(R.id.name, item.getEntity_commentUser().getNickname())
                .setText(R.id.num, item.getLikedCount())
                .setText(R.id.connect, item.getContent());
    }

    @Override
    protected int getItemViewLayoutId(int position, Data_commentsMsg item) {
        return R.layout.item_comments;
    }
}
