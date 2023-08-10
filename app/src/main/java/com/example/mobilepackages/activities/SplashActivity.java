package com.example.mobilepackages.activities;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.mobilepackages.R;
import com.facebook.shimmer.ShimmerFrameLayout;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      getWindow().requestFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash);
        ShimmerFrameLayout container = (ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);
         container.startShimmer();
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                SplashActivity splashActivity = SplashActivity.this;
                splashActivity.startActivity(new Intent(splashActivity, NetwoksListActivity.class));
                SplashActivity.this.finish();
            }
        },4000);


    }
}
