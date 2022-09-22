package com.basudev.news.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.basudev.news.Adapter.RecyclerViewAdapter;
import com.basudev.news.Retrofit.ApiUtilities;
import com.basudev.news.ModelClass.NewsModel;
import com.basudev.news.R;
import com.basudev.news.ModelClass.mainNews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    String api="a0b796bbc7934fdf982268b0df9b0154";
    ArrayList<NewsModel> newsModels;
    RecyclerViewAdapter adapter;
    String country="in";
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_home,container,false);

        recyclerView=v.findViewById(R.id.RecViewOfHome);
        newsModels=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=  new RecyclerViewAdapter(getContext(),newsModels);
        recyclerView.setAdapter(adapter);
        SwipeRefreshLayout swipeRefreshLayout;
        swipeRefreshLayout=v.findViewById(R.id.srHome);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newsModels.clear();
                findNews();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        findNews();

        return v;
    }
    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    newsModels.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}