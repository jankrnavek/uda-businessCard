package com.example.android.businesscard;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String OUR_WEBPAGE = "https://www.mydjango.cz";
    private static final String TO_EMAIL = "info@mydjango.cz";
    private static final String EMAIL_SUJECT = "hello there";
    private static final String PHONE_NUMBER = "+420101123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Go to www.mydjango.cz when clicking on picture
        ImageView img = findViewById(R.id.img_python_django);

        img.setClickable(true);
        img.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent();
                in.setAction(Intent.ACTION_VIEW);
                in.addCategory(Intent.CATEGORY_BROWSABLE);
                in.setData(Uri.parse(OUR_WEBPAGE));

                if (in.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(in, "Open in browser:"));
                } else {
                    Log.i("Main_activity", "Couldn't find a browser app !");
                }
            }
        });

        // Go to www.mydjango.cz when clicking on button
        Button b1 = findViewById(R.id.button_webpage);

        b1.setClickable(true);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent();
                in.setAction(Intent.ACTION_VIEW);
                in.addCategory(Intent.CATEGORY_BROWSABLE);
                in.setData(Uri.parse(OUR_WEBPAGE));

                if (in.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(in, "Open in browser:"));
                } else {
                    Log.i("Main_activity", "Couldn't find a browser app !");
                }
            }
        });

        // Send us email when clicking on button
        Button b2 = findViewById(R.id.button_email);

        b2.setClickable(true);
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent();
                in.setAction(Intent.ACTION_SEND);
                in.putExtra(Intent.EXTRA_EMAIL, new String[]{TO_EMAIL});
                in.putExtra(Intent.EXTRA_SUBJECT, EMAIL_SUJECT);
                in.setType("plain/text");
//                in.setType("message/rfc822");

                if (in.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(in, "Send your email in:"));
                } else {
                    String msg = "Couldn't find an email app !";

                    Log.i("Main_activity", msg);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            }
        });


        // Call us when clicking on button
        Button b3 = findViewById(R.id.button_call);

        b3.setClickable(true);
        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent in = new Intent();
                in.setAction(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:" + PhoneNumberUtils.normalizeNumber(PHONE_NUMBER)));

                if (in.resolveActivity(getPackageManager()) != null) {
                    startActivity(in);
                } else {
                    Log.i("Main_activity", "Couldn't find a phone app !");
                }
            }
        });

    }
}
