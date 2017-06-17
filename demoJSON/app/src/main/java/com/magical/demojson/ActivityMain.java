package com.magical.demojson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.magical.demojson.model.ModelNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity {


    ListView mNewsList;

    List<ModelNews> modelNewsList = new ArrayList<>();
    AdapterNews mAdapterNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNewsList = (ListView) findViewById(R.id.my_news_list);

        mAdapterNews = new AdapterNews(this, modelNewsList);

        mNewsList.setAdapter(mAdapterNews);


        mNewsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(ActivityMain.this, ActivityNewsDetails.class);
                ModelNews modelNews = modelNewsList.get(position);
                intent.putExtra(ActivityNewsDetails.KEY_TITLE, modelNews.getTitle());
                intent.putExtra(ActivityNewsDetails.KEY_DATE, modelNews.getDate());
                intent.putExtra(ActivityNewsDetails.KEY_PUBLISHER, modelNews.getPublisher());

                startActivity(intent);
            }
        });

        getListFromServerData(getDataFromServer());


        // Converting JSON to String
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("first_name", "Anil");
            jsonObject.put("last_name", "J");
            jsonObject.put("package", 4.2);
            jsonObject.put("age", 22);


            Log.d(" jsonObject.toString() ", jsonObject.toString());

            Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // Converting String to JSON
        // GSON or JakSON
        String response = "{\"user_name\":\"admin\" ,\"password\":\"abc123\"}";
        try {
            JSONObject jsonLoginDetails = new JSONObject(response);

            String user_name = jsonLoginDetails.getString("user_name");
            String password = jsonLoginDetails.getString("password");

            Log.d("MYAPP", user_name + " : " + password);

//            ModelLogin modelLogin = new ModelLogin();
//            modelLogin.setUserName(user_name);
//            modelLogin.setPassword(password);

            Toast.makeText(this, user_name + " : " + password, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            Log.e("MYAPP", "JSON EXception", e);
        }


    }


    private void getListFromServerData(String dataFromServer) {

        try {
            JSONObject jsonObject = new JSONObject(dataFromServer);

            JSONArray newsArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < newsArray.length(); i++) {
                JSONObject jsonObjectNews = newsArray.getJSONObject(i);

                ModelNews modelNews = new ModelNews();
                modelNews.setDate(jsonObjectNews.getString("news_data"));
                modelNews.setTitle(jsonObjectNews.getString("news_title"));
                modelNews.setPublisher(jsonObjectNews.getString("news_publisher"));

                modelNewsList.add(modelNews);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public String getDataFromServer() {
        return "{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"Success got data\",\n" +
                "  \"title\": \"Success\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"news_title\": \"Title 1\",\n" +
                "      \"news_data\": \"12-06-2015\",\n" +
                "      \"news_publisher\": \"Times of India\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"news_title\": \"Title 2\",\n" +
                "      \"news_data\": \"12-06-2015\",\n" +
                "      \"news_publisher\": \"Times of India\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"news_title\": \"Title 2b\",\n" +
                "      \"news_data\": \"12-06-2015\",\n" +
                "      \"news_publisher\": \"Times of India\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"news_title\": \"Title 3\",\n" +
                "      \"news_data\": \"12-06-2015\",\n" +
                "      \"news_publisher\": \"Times of India\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"news_title\": \"Title 4\",\n" +
                "      \"news_data\": \"12-06-2015\",\n" +
                "      \"news_publisher\": \"Times of India\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"news_title\": \"Title 5\",\n" +
                "      \"news_data\": \"12-06-2015\",\n" +
                "      \"news_publisher\": \"Times of India\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"news_title\": \"Title 6\",\n" +
                "      \"news_data\": \"12-06-2015\",\n" +
                "      \"news_publisher\": \"Times of India\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"news_title\": \"Title 7\",\n" +
                "      \"news_data\": \"12-06-2015\",\n" +
                "      \"news_publisher\": \"Times of India\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
