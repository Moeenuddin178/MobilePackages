package com.example.mobilepackages.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilepackages.R;
import com.example.mobilepackages.Utils;
import com.example.mobilepackages.databases.MyDbHelper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MyAddActivity extends AppCompatActivity {
    public static MyDbHelper mSQLiteHelper;
    private EditText activationEt;
    private Button addBtn;
    private EditText deactivationEt;
    private EditText durationEt;
    private InterstitialAd mInterstitialAd;
    private EditText priceEt;
    private EditText remainingEt;
    private String tableName;
    private EditText titleEt;
    private EditText volumeEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_add);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowHomeEnabled(true);
        MyDbHelper myDbHelper = new MyDbHelper(this, "RECORDDB.sqlite", null, 1);
        mSQLiteHelper = myDbHelper;
        myDbHelper.queryData("CREATE TABLE IF NOT EXISTS JazzWarid(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
        mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Telenor(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
        mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Ufone(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
        mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Zong(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
        this.titleEt = (EditText) findViewById(R.id.titleEt);
        this.durationEt = (EditText) findViewById(R.id.durationEt);
        this.volumeEt = (EditText) findViewById(R.id.volumeEt);
        this.activationEt = (EditText) findViewById(R.id.activationEt);
        this.deactivationEt = (EditText) findViewById(R.id.deactivationEt);
        this.remainingEt = (EditText) findViewById(R.id.remainingEt);
        this.priceEt = (EditText) findViewById(R.id.priceEt);
        this.addBtn = (Button) findViewById(R.id.addBtn);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("tableName");
        this.tableName = stringExtra;
        supportActionBar.setSubtitle(stringExtra);
        final String stringExtra2 = intent.getStringExtra("id");
        String stringExtra3 = intent.getStringExtra("title");
        String stringExtra4 = intent.getStringExtra("duration");
        String stringExtra5 = intent.getStringExtra("volume");
        String stringExtra6 = intent.getStringExtra("activation");
        String stringExtra7 = intent.getStringExtra("deactivation");
        String stringExtra8 = intent.getStringExtra("remaining");
        // todo String stringExtra9 = intent.getStringExtra(FirebaseAnalytics.Param.PRICE);
        String stringExtra9 = "123";
        if (stringExtra3 != null) {
            this.titleEt.setText(stringExtra3);
            this.durationEt.setText(stringExtra4);
            this.volumeEt.setText(stringExtra5);
            this.activationEt.setText(stringExtra6);
            this.deactivationEt.setText(stringExtra7);
            this.remainingEt.setText(stringExtra8);
            this.priceEt.setText(stringExtra9);
            this.addBtn.setText("UPDATE");
            supportActionBar.setTitle("Update Package");
        } else {
            supportActionBar.setTitle("Add New Package");
            this.addBtn.setText("ADD");
        }
        InterstitialAd interstitialAd = new InterstitialAd(this);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdUnitId(getString(R.string.interstitial_id1));
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.addBtn.setOnClickListener(new View.OnClickListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.MyAddActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MyAddActivity.this.addBtn.getText().equals("ADD")) {
                    MyAddActivity.this.addPackage();
                } else if (MyAddActivity.this.addBtn.getText().equals("UPDATE")) {
                    MyAddActivity.this.updatePackage(Integer.parseInt(stringExtra2));
                } else {
                    Toast.makeText(MyAddActivity.this, "Not ADD nor UPDATE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void addPackage() {
        try {
            mSQLiteHelper.insertData(this.tableName, this.titleEt.getText().toString().trim(), this.durationEt.getText().toString().trim(), this.volumeEt.getText().toString().trim(), this.activationEt.getText().toString().trim(), this.deactivationEt.getText().toString().trim(), this.remainingEt.getText().toString().trim(), this.priceEt.getText().toString().trim());
            Toast.makeText(this, "Added successfully...\nChanges will apply after restarting app", Toast.LENGTH_SHORT).show();
            this.titleEt.setText("");
            this.durationEt.setText("");
            this.volumeEt.setText("");
            this.activationEt.setText("");
            this.deactivationEt.setText("");
            this.remainingEt.setText("");
            this.priceEt.setText("");
        } catch (Exception e) {
            Log.d("string error",e.getMessage());
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void updatePackage(int i) {
        try {
            mSQLiteHelper.updateData(this.tableName, this.titleEt.getText().toString().trim(), this.durationEt.getText().toString().trim(), this.volumeEt.getText().toString().trim(), this.activationEt.getText().toString().trim(), this.deactivationEt.getText().toString().trim(), this.remainingEt.getText().toString().trim(), this.priceEt.getText().toString().trim(), i);
            Toast.makeText(getApplicationContext(), "Updated successfully...\nChanges will apply after restarting app", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_search).setVisible(false);
        menu.findItem(R.id.addItem).setVisible(false);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_about) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd == null || !interstitialAd.isLoaded()) {
                startActivity(new Intent(this, AboutActivity.class));
            } else {
                this.mInterstitialAd.show();
            }
            this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.MyAddActivity.2
                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    MyAddActivity.this.startActivity(new Intent(MyAddActivity.this, AboutActivity.class));
                }
            });
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