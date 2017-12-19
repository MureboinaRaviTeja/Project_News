package com.example.mravi.infrmr.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mravi.infrmr.controller.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mravi on 20-12-2017.
 */

public class ArticleData {

    ArrayList<Article> articles =new ArrayList<>();

    String url = "https://newsapi.org/v2/everything?sources=techcrunch&apiKey=bb090da5434e4660990c82e06262f90f";
    public void getNewsList(final ArticleListAsyncResponse callBack){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,
                url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    JSONArray articalArray=response.getJSONArray("articles");

                for(int i=0;i<articalArray.length();i++){

                    //create article object;
                    JSONObject articleObject=articalArray.getJSONObject(i);
                    Article article=new Article();
                    article.setAuthor(articleObject.getString("author"));
                article.setTitle(articleObject.getString("title"));
                article.setDescription(articleObject.getString("description"));
                article.setImageUrl(articleObject.getString("urlToImage"));
                article.setPublishedDate(articleObject.getString("publishedAt"));
article.setNewsUrl(articleObject.getString("url"));


                articles.add(article);


                if(null!=callBack)callBack.processFinish(articles);


                }

Log.v("Article object:",articles.toString());



                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }



}
