package com.example.mobilepackages.activities;

import android.content.Intent;
import android.database.Cursor;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobilepackages.R;
import com.example.mobilepackages.Utils;
import com.example.mobilepackages.adapter.ListAdapter;
import com.example.mobilepackages.databases.DataBaseHelper;
import com.example.mobilepackages.models.Model;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;



public class NetworkOptionDetailActivity extends AppCompatActivity {
    private static final String DB_NAME = "Database.db";
    Model model;

    Intent intent;
    private ListAdapter listAdapter;
    DataBaseHelper mDbHelper;
    InterstitialAd mInterstitialAd;
    private ListView mListView;
    String title;

    private void showPackageDetails(String paramString) {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        Cursor cursor = mDbHelper.rawQuery(paramString);
        if (cursor == null) {

            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
        }
        if (cursor != null && cursor.getCount() != 0 && cursor.moveToFirst())
            do {
                model = new Model();
                 model.setTitle(cursor.getString(cursor.getColumnIndex("TITLE")).replace("\\n", "\n"));
                model.setDuration(cursor.getString(cursor.getColumnIndex("DURATION")).replace("\\n", "\n"));
                model.setVolume(cursor.getString(cursor.getColumnIndex("VOLUME")).replace("\\n", "\n"));
                model.setActivation(cursor.getString(cursor.getColumnIndex("ACTIVATION")).replace("\\n", "\n"));
                model.setDeactivation(cursor.getString(cursor.getColumnIndex("DEACTIVATION")).replace("\\n", "\n"));
                model.setRemaining(cursor.getString(cursor.getColumnIndex("REMAINING")).replace("\\n", "\n"));
                model.setInfo(cursor.getString(cursor.getColumnIndex("INFO")).replace("\\n", "\n"));
                model.setPrice(cursor.getString(cursor.getColumnIndex("PRICE")).replace("\\n", "\n"));
                arrayList.add(model);
            } while (cursor.moveToNext());

//        Toast.makeText(this, cursor.getColumnCount(), Toast.LENGTH_SHORT).show();
        cursor.close();
        this.listAdapter = new ListAdapter(this, arrayList);
       this.mListView.setAdapter(this.listAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_option_detail);
        ActionBar actionBar = getSupportActionBar();
        byte b = 1;
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        // testhelper dbHelper;
        // ArrayList<Model> modelList;
        //String chap="";
        //modelList = new ArrayList<>();
        //modelList.clear();
        //dbHelper = new testhelper(this);
        //dbHelper.openDataBase();
        // mDbHelper=getInstance(this,DB_NAME);
        //modelList = dbHelper.getDetails();
        //get first record

        // int s=  modelList.size();
        // Model count = modelList.get(0);
        //save record in strings
        // String activation =  count.getActivation();
        // Toast.makeText(this,activation, Toast.LENGTH_SHORT).show();

        //   mDbHelper = getInstance(this, "Database.db" );
        mDbHelper = new DataBaseHelper(getApplicationContext());
        mDbHelper.createDatabase();
       // mDbHelper.openDatabase();

        this.mListView = (ListView) findViewById(R.id.listView);
        this.intent = getIntent();
        this.title = this.intent.getStringExtra("title");
        String str = this.title;
        switch (str.hashCode()) {
            default:
                b = -1;
                break;
            case 1335399598:
                if (str.equals("Ufone SMS")) {
                    b = 11;
                    break;
                }
            case 1335395570:
                if (str.equals("Ufone Net")) {
                    b = 12;
                    break;
                }
            case 1241076565:
                if (str.equals("Ufone All In One")) {
                    b = 13;
                    break;
                }
            case 1179108762:
                if (str.equals("Warid Broadband")) {
                    b = 18;
                    break;
                }
            case 1130854496:
                if (str.equals("Telenor SMS")) {
                    b = 6;
                    break;
                }
            case 1130850468:
                if (str.equals("Telenor Net")) {
                    b = 7;
                    break;
                }
            case 1093440199:
                if (str.equals("Warid All In One")) {
                    b = 17;
                    break;
                }
            case 1071935015:
                if (str.equals("Jazz Call")) {
                    b = 0;
                    break;
                }
            case 1034221564:
                if (str.equals("Zong All In One")) {
                    b = 22;
                    break;
                }
            case 1000837502:
                if (str.equals("Telenor Broadband")) {
                    b = 9;
                    break;
                }
            case 913165799:
                if (str.equals("Zong SMS")) {
                    b = 20;
                    break;
                }
            case 913161771:
                if (str.equals("Zong Net")) {
                    b = 21;
                    break;
                }
            case 696294455:
                if (str.equals("Telenor Call")) {
                    b = 5;
                    break;
                }
            case 114815356:
                if (str.equals("Warid SMS")) {
                    b = 15;
                    break;
                }
            case 114811328:
                if (str.equals("Warid Net")) {
                    b = 16;
                    break;
                }
            case 102818131:
                if (str.equals("Jazz All In One")) {
                    b = 3;
                    break;
                }
            case -138001565:
                if (str.equals("Telenor All In One")) {
                    b = 8;
                    break;
                }
            case -376867442:
                if (str.equals("Jazz Broadband")) {
                    b = 4;
                    break;
                }
            case -381048720:
                if (str.equals("Jazz SMS"))
                    break;
            case -381052748:
                if (str.equals("Jazz Net")) {
                    b = 2;
                    break;
                }
            case -736147813:
                if (str.equals("Warid Call")) {
                    b = 14;
                    break;
                }
            case -1455200827:
                if (str.equals("Zong Broadband")) {
                    b = 23;
                    break;
                }
            case -1552741975:
                if (str.equals("Ufone Call")) {
                    b = 10;
                    break;
                }
            case -1757087856:
                if (str.equals("Zong Call")) {
                    b = 19;
                    break;
                }
        }
        switch (b) {
            case 23:
                actionBar.setTitle("Zong Broadband");
                actionBar.setSubtitle("Detailed list of Broadband packages...");
                showPackageDetails("SELECT * FROM ZongBroad");
                break;
            case 22:
                actionBar.setSubtitle("Detailed list of All In One packages...");
                actionBar.setTitle("Zong All In One");
                showPackageDetails("SELECT * FROM ZongAll");
                break;
            case 21:
                actionBar.setTitle("Zong 3G/4G");
                actionBar.setSubtitle("Detailed list of Internet packages...");
                showPackageDetails("SELECT * FROM ZongNet");
                break;
            case 20:
                actionBar.setTitle("Zong SMS");
                actionBar.setSubtitle("Detailed list of SMS packages...");
                showPackageDetails("SELECT * FROM ZongSMS");
                break;
            case 19:
                actionBar.setTitle("Zong Call");
                actionBar.setSubtitle("Detailed list of Call packages...");
                showPackageDetails("SELECT * FROM ZongCall");
                break;
            case 18:
                actionBar.setTitle("Jazz Warid Broadband");
                actionBar.setSubtitle("Detailed list of Broadband packages...");
                showPackageDetails("SELECT * FROM JazzBroad");
                break;
            case 17:
                actionBar.setTitle("Jazz Warid All In One");
                actionBar.setSubtitle("Detailed list of All In One packages...");
                showPackageDetails("SELECT * FROM JazzAll");
                break;
            case 16:
                actionBar.setTitle("Jazz Warid 3G/4G");
                actionBar.setSubtitle("Detailed list of Internet packages...");
                showPackageDetails("SELECT * FROM JazzNet");
                break;
            case 15:
                actionBar.setTitle("Jazz Warid SMS");
                actionBar.setSubtitle("Detailed list of SMS packages...");
                showPackageDetails("SELECT * FROM JazzSMS");
                break;
            case 14:
                actionBar.setTitle("Jazz Warid Call");
                actionBar.setSubtitle("Detailed list of Call packages...");
                showPackageDetails("SELECT * FROM JazzCall");
                break;
            case 13:
                actionBar.setTitle("Ufone All In One");
                actionBar.setSubtitle("Detailed list of All In One packages...");
                showPackageDetails("SELECT * FROM UfoneAll");
                break;
            case 12:
                actionBar.setTitle("Ufone 3G/4G");
                actionBar.setSubtitle("Detailed list of Internet packages...");
                showPackageDetails("SELECT * FROM UfoneNet");
                break;
            case 11:
                actionBar.setTitle("Ufone SMS");
                actionBar.setSubtitle("Detailed list of SMS packages...");
                showPackageDetails("SELECT * FROM UfoneSMS");
                break;
            case 10:
                actionBar.setTitle("Ufone Call");
                actionBar.setSubtitle("Detailed list of Call packages...");
                showPackageDetails("SELECT * FROM UfoneCall");
                break;
            case 9:
                actionBar.setTitle("Telenor Broadband");
                actionBar.setSubtitle("Detailed list of Boradband packages...");
                showPackageDetails("SELECT * FROM TelenorBroad");
                break;
            case 8:
                actionBar.setTitle("Telenor All In One");
                actionBar.setSubtitle("Detailed list of All In One packages...");
                showPackageDetails("SELECT * FROM TelenorAll");
                break;
            case 7:
                actionBar.setTitle("Telenor 3G/4G");
                actionBar.setSubtitle("Detailed list of Internet packages...");
                showPackageDetails("SELECT * FROM TelenorNet");
                break;
            case 6:
                actionBar.setTitle("Telenor SMS");
                actionBar.setSubtitle("Detailed list of SMS packages...");
                showPackageDetails("SELECT * FROM TelenorSMS");
                break;
            case 5:
                actionBar.setTitle("Telenor Call");
                actionBar.setSubtitle("Detailed list of Call packages...");
                showPackageDetails("SELECT * FROM TelenorCall");
                break;
            case 4:
                actionBar.setTitle("Jazz Broadband");
                actionBar.setSubtitle("Detailed list of Broadband packages...");
                showPackageDetails("SELECT * FROM JazzBroad");
                break;
            case 3:
                actionBar.setTitle("Jazz All In One");
                actionBar.setSubtitle("Detailed list of All In One packages...");
                showPackageDetails("SELECT * FROM JazzAll");
                break;
            case 2:
                actionBar.setTitle("Jazz 3G/4G");
                actionBar.setSubtitle("Detailed list of Internet packages...");
                showPackageDetails("SELECT * FROM JazzNet");
                break;
            case 1:
                actionBar.setTitle("Jazz SMS");
                actionBar.setSubtitle("Detailed list of SMS packages...");
                showPackageDetails("SELECT * FROM JazzSMS");
                break;
            case 0:
                actionBar.setTitle("Jazz Call");
                actionBar.setSubtitle("Detailed list of Call packages...");
                showPackageDetails("SELECT * FROM JazzCall");
                break;
        }
        this.mInterstitialAd = new InterstitialAd(this);
        this.mInterstitialAd.setAdUnitId("ca-app-pub-8967464574011121/3523145996");
        // this.mInterstitialAd.loadAd((new AdRequest.Builder()).addTestDevice(getString(2131624016)).build());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        int i = paramMenuItem.getItemId();
        if (i == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        if (i == R.id.action_rate) {
            Utils.rateApp(this);
            return true;
        }
        if (i == R.id.action_moreapps) {
            Utils.moreApps(this);
            return true;
        }
        if (i == R.id.action_share) {
            Utils.shareApp(this);
        } else if (i == R.id.action_addjazwar) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent1 = new Intent(this, MyAddActivity.class);
                intent1.putExtra("tableName", "JazzWarid");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionDetailActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "JazzWarid");
                    NetworkOptionDetailActivity.this.startActivity(intent);
                }
            });
        } else if (i == R.id.action_addtelenor) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent1 = new Intent(this, MyAddActivity.class);
                intent1.putExtra("tableName", "Telenor");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionDetailActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Telenor");
                    NetworkOptionDetailActivity.this.startActivity(intent);
                }
            });
        } else if (i == R.id.action_addufone) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent1 = new Intent(this, MyAddActivity.class);
                intent1.putExtra("tableName", "Ufone");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionDetailActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Ufone");
                    NetworkOptionDetailActivity.this.startActivity(intent);
                }
            });
        } else if (i == R.id.action_addzong) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent1 = new Intent(this, MyAddActivity.class);
                intent1.putExtra("tableName", "Zong");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionDetailActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Zong");
                    NetworkOptionDetailActivity.this.startActivity(intent);
                }
            });
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }


    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
