package com.magical.demojson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}
