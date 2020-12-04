package com.example.a26_recyclerview_cardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<CardViewModel> mItem;

    public MyAdapter(List<CardViewModel> item) {
        this.mItem = item;
    }

    //클릭 리스너 만들기
    interface OnCardItemSelectedListener {
        //달아줄 뷰 객체마다 만들어줌.
        void onItemSelected(int position);

        void onTitleSelected(int position);

        void onContentsSelected(int position);

        void onShareSelected(int position);

        void onLearnSelected(int position);

    }

    //연결 메소드
    public void setOnCardItemSelected(OnCardItemSelectedListener listener) {
        mListener = listener;
    }

    OnCardItemSelectedListener mListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardViewModel item = mItem.get(position);
        holder.title.setText(item.getTitle());
        holder.contents.setText(item.getContents());
        //포지션을 메소드로 전달.
        //아이템을 전달해 줄수도 있음.
        holder.itemView.setOnClickListener(v -> {
            mListener.onItemSelected(position);
        });
        holder.title.setOnClickListener(v -> {
            mListener.onTitleSelected(position);
        });
        holder.contents.setOnClickListener(v -> {
            mListener.onContentsSelected(position);
        });
        holder.share.setOnClickListener(v -> {
            mListener.onShareSelected(position);
        });
        holder.learn.setOnClickListener(v -> {
            mListener.onLearnSelected(position);
        });

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView contents;
        Button share;
        Button learn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_text_title);
            contents = itemView.findViewById(R.id.item_text_contents);
            share = itemView.findViewById(R.id.item_btn_share);
            learn = itemView.findViewById(R.id.item_btn_learn);
        }
    }
}
