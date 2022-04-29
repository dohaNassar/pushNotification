package com.example.pushnotificationlecture;


import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FCMSend {

    private static String BASE_URL = "https://fcm.googleapis.com/fcm/send";
    private static String SERVER_KEY = "key=AAAAufUhMKQ:APA91bGmw2cmh3uGEIyvh7iJBt7gq682eAqDIAd-zhF1gN9MwxUMC08j6r3N3pgsmxFF6ZU9FNpuZVHn5igK2UbBXGGPX2bW7JJwdN80S1M_sPVYZ84OOc_Ykk8HoOx7zUGa150gKiLr";
    private static String TAG = "FCMSend";

    public static void sendNotificationReq(Context context
            , ArrayList<String> tokens
            , String title
            , String body){

        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject mainObject = new JSONObject();
        JSONArray arr = new JSONArray();
        for (String a:
             tokens) {
            arr.put(a);
        }
        try {
            mainObject.put("registration_ids", arr);
            JSONObject notificationObject = new JSONObject();
            notificationObject.put("title", title);
            notificationObject.put("body", body);
            mainObject.put("notification", notificationObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST
                ,BASE_URL
                ,mainObject
                ,response -> {
            Log.d(TAG, "sendNotificationReq: Done");
        },error -> {
            Log.d(TAG, "sendNotificationReq: Failed -> "+error.getMessage());
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                params.put("Authorization", SERVER_KEY);
                return params;
            }
        };

        queue.add(request);
    }
}
