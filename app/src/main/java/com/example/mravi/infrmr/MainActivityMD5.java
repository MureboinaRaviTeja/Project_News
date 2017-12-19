package com.example.mravi.infrmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.mravi.infrmr.data.Article;
import com.example.mravi.infrmr.data.ArticleAdapter;
import com.example.mravi.infrmr.data.ArticleData;
import com.example.mravi.infrmr.data.ArticleListAsyncResponse;

import java.util.ArrayList;

public class MainActivityMD5 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_md5);


        new ArticleData().getNewsList(new ArticleListAsyncResponse() {
            @Override
            public void processFinish(final ArrayList<Article> articles) {

           recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
                articleAdapter=new ArticleAdapter(articles,getApplicationContext());

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(articleAdapter);

                articleAdapter.setOnClickListener(new ArticleAdapter.OnItemClickListner() {
                    @Override
                    public void onItemClick(View view, int position) {


                        Article article=articles.get(position);
                        Intent intent=new Intent(getApplication(),DetailsActivity.class);
                        intent.putExtra("url",article.getNewsUrl());
                        startActivity(intent);





                        //Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();



                    }
                });


            }
        });


    }
}
