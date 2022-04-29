package com.example.pushnotificationlecture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static String TAG = "ttt";
    static String token1 = "d0JX4dycR0qU3eLDR4RJmi:APA91bEwCY5tnugQy_6V-YF1H8uwOYPhd4LzsZ0nyqAQwryHY5GJ86A9XbdQGoRdksZ-UB5BxkuDMsTdN2LZrVYbyrvoPizmP6bcRJSU-gd-FtYo53v18jf5BSdAxyLmtHPw3xn2fJ3I";
    static String token2 = "cEX2ncNBR8Ga-jQg6eR5F6:APA91bHXcGB6THhPn6FHyRpSWiyt9Jiue0P4XF_a3OouywevjR8Gj6N7TprQlRIdowPn97XgbcqdzR_QyTtUaOdEYCRNR9r8qL4SEODoz-3sPVWaT0zEq1Cp_SKj_a4utTFm063dsmHX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> tokens = new ArrayList<>();
        tokens.add(token1);
        tokens.add(token2);
        Button btn = findViewById(R.id.push_noti_btn);
        btn.setOnClickListener(v ->
        {
            FCMSend.sendNotificationReq(this, tokens,"Hello", "Text text .....");
        });


        /*FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task ->{
          if(!task.isSuccessful())  {
              return;
          }

            Log.d(TAG, "onCreate: "+task.getResult());
        });*/


    }
}