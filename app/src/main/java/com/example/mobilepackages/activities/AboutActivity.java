package com.example.mobilepackages.activities;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mobilepackages.R;
import com.example.mobilepackages.Utils;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("About/Help");
            supportActionBar.setSubtitle("Information about app...");
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
    }
    public void optionsClick(View view) {
        if (view == findViewById(R.id.feedback)) {
          //todo  Utils.feedback(this);
        } else if (view == findViewById(R.id.website)) {
            Utils.website(this);
        } else if (view == findViewById(R.id.privacy)) {
            Utils.privacyPolicy(this);
        } else if (view == findViewById(R.id.rate)) {
            Utils.rateApp(this);
        } else if (view == findViewById(R.id.share)) {
            Utils.shareApp(this);
        } else if (view == findViewById(R.id.more)) {
            Utils.moreApps(this);
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_about).setVisible(false);
        menu.findItem(R.id.action_search).setVisible(false);
        menu.findItem(R.id.addItem).setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        } else if (itemId == R.id.action_rate) {
            Utils.rateApp(this);
            return true;
        } else if (itemId == R.id.action_moreapps) {
            Utils.moreApps(this);
            return true;
        } else {
            if (itemId == R.id.action_share) {
                Utils.shareApp(this);
            }
            return super.onOptionsItemSelected(menuItem);
        }
    }
}
