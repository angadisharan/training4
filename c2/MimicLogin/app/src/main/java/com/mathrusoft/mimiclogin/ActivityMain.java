package com.mathrusoft.mimiclogin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.mathrusoft.mimiclogin.model.ModelNews;
import com.mathrusoft.mimiclogin.model.ModelStudent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 26/06/17.
 */

public class ActivityMain extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this.getApplicationContext();

        mimicServerResponse();
        mimicRequestBody();
    }


    String response = "{\n" +
            "  \"student_name\": \"Vipul\",\n" +
            "  \"student_address\": \"Rajajinagar\",\n" +
            "  \"student_age\": 20,\n" +
            "  \"student_usn\": \"2ba12568\",\n" +
            "  \"student_cgpa\": 8.14\n" +
            "}\n";

    private void mimicServerResponse() {

        try {
            JSONObject jsonStudent = new JSONObject(response);


            Log.d("MYAPP", "student name : " + jsonStudent.getString("student_name"));
            Log.d("MYAPP", "student student_address : " + jsonStudent.getString("student_address"));
            Log.d("MYAPP", "student name : " + jsonStudent.getInt("student_age"));
            Log.d("MYAPP", "student student_usn : " + jsonStudent.getString("student_usn"));

            ModelStudent modelStudent = new ModelStudent();
            modelStudent.setAddress(jsonStudent.getString("student_address"));
            modelStudent.setName(jsonStudent.getString("student_name"));
            modelStudent.setAge(jsonStudent.getInt("student_age"));
            modelStudent.setUsn(jsonStudent.getString("student_usn"));

            Toast.makeText(mContext, " student " + jsonStudent.getString("student_name"), Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {

            Log.e("MYAPP", "Exception ", e);
        }
    }

    private void mimicRequestBody() {
        ModelNews modelNews = new ModelNews();
        modelNews.setTitle("GST");
        modelNews.setSubTitle("Modi Govt");
        modelNews.setViews(30);
        modelNews.setUrl("http://info.mathrusoft.com/news/article/1");


        JSONObject jsonNews = new JSONObject();
        try {
            jsonNews.put("news_title", modelNews.getTitle());
            jsonNews.put("news_subtitle", modelNews.getSubTitle());
            jsonNews.put("news_views", modelNews.getViews());
            jsonNews.put("news_url", modelNews.getUrl());

            Log.d("MYAPP", " JSON News" + jsonNews.toString());
        } catch (JSONException e) {
            Log.e("MYAPP", "Exception ", e);
        }
    }


    String newsListFromServer = "{\n" +
            "  \"success\": true,\n" +
            "  \"message\": \"Success got data\",\n" +
            "  \"title\": \"Success\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"news_title\": \"Title 1\",\n" +
            "      \"news_date\": \"12-06-2015\",\n" +
            "      \"news_publisher\": \"Times of India\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"news_title\": \"Title 2\",\n" +
            "      \"news_date\": \"12-06-2015\",\n" +
            "      \"news_publisher\": \"Times of India\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"news_title\": \"Title 2b\",\n" +
            "      \"news_date\": \"12-06-2015\",\n" +
            "      \"news_publisher\": \"Times of India\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"news_title\": \"Title 3\",\n" +
            "      \"news_date\": \"12-06-2015\",\n" +
            "      \"news_publisher\": \"Times of India\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"news_title\": \"Title 4\",\n" +
            "      \"news_date\": \"12-06-2015\",\n" +
            "      \"news_publisher\": \"Times of India\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"news_title\": \"Title 5\",\n" +
            "      \"news_date\": \"12-06-2015\",\n" +
            "      \"news_publisher\": \"Times of India\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"news_title\": \"Title 6\",\n" +
            "      \"news_date\": \"12-06-2015\",\n" +
            "      \"news_publisher\": \"Times of India\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"news_title\": \"Title 7\",\n" +
            "      \"news_date\": \"12-06-2015\",\n" +
            "      \"news_publisher\": \"Times of India\"\n" +
            "    }\n" +
            "  ]\n" +
            "}\n" +
            "\n";

    private void mimicParseNewsFromServer(String response) {
        List<ModelNews> modelNewsList = new ArrayList<>();

        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray jsonArray = jsonResponse.getJSONArray("data");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                ModelNews modelNews = new ModelNews();
                modelNews.setTitle(jsonObject.getString("news_title"));
                modelNewsList.add(modelNews);
            }

        } catch (JSONException e) {
            Log.e("MYAPP", "Exceptriion ", e);
        }


    }


}
