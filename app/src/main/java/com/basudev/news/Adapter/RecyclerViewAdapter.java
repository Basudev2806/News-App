package com.basudev.news.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.basudev.news.ModelClass.NewsModel;
import com.basudev.news.R;
import com.basudev.news.Activities.webView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<NewsModel> newsModels;

    public RecyclerViewAdapter(Context context, ArrayList<NewsModel> newsModels) {
        this.context = context;
        this.newsModels = newsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, webView.class);
                i.putExtra("url",newsModels.get(position).getUrl());
                context.startActivity(i);
            }
        });
        holder.time.setText("Published At:-"+newsModels.get(position).getPublishedAt());
        holder.author.setText(newsModels.get(position).getAuthor());
        holder.heading.setText(newsModels.get(position).getAuthor());
        holder.heading.setText(newsModels.get(position).getTitle());
        holder.content.setText(newsModels.get(position).getDescription());
        Glide.with(context).load(newsModels.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading,content,author,time;
        CardView cardView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            heading=itemView.findViewById(R.id.mainHeading);
            content=itemView.findViewById(R.id.content);
            author=itemView.findViewById(R.id.author);
            cardView=itemView.findViewById(R.id.cardView);
            time=itemView.findViewById(R.id.time);
        }
    }
}
