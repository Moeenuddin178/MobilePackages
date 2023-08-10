package com.example.mobilepackages.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mobilepackages.R;
import com.example.mobilepackages.Utils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class NetwoksListActivity extends AppCompatActivity {
    Boolean IsReset = Boolean.valueOf(false);

    InterstitialAd mInterstitialAd;

    private void showBanner() {
        AdView adView = (AdView) findViewById(R.id.adView1);
        //  adView.setVisibility(0);
        adView.loadAd((new AdRequest.Builder()).addTestDevice("Test Device Id here").build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netwoks_list);
        showBanner();
        this.mInterstitialAd = new InterstitialAd(this);
        this.mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        this.mInterstitialAd.loadAd((new AdRequest.Builder()).addTestDevice("Your device id here").build());

    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_search).setVisible(false);
        MenuItem findItem = menu.findItem(R.id.addItem);
        if (!this.IsReset.booleanValue()) {
            findItem.setVisible(true);
        } else {
            findItem.setVisible(false);
        }
        return true;
    }




    //packages buttons




    public void packagesBtn(View view) {
        if (view == findViewById(R.id.jazzBtn)) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd == null || !interstitialAd.isLoaded()) {
                Intent intent = new Intent(this, NetworkOptionsActivity.class);
                intent.putExtra("title", "Jazz");
                startActivity(intent);
            } else {
                this.mInterstitialAd.show();
            }
            this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.1
                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    Intent intent2 = new Intent(NetwoksListActivity.this, NetworkOptionsActivity.class);
                    intent2.putExtra("title", "Jazz");
                    NetwoksListActivity.this.startActivity(intent2);
                }
            });
        } else if (view == findViewById(R.id.telenorBtn)) {
            InterstitialAd interstitialAd2 = this.mInterstitialAd;
            if (interstitialAd2 == null || !interstitialAd2.isLoaded()) {
                Intent intent2 = new Intent(this, NetworkOptionsActivity.class);
                intent2.putExtra("title", "Telenor");
                startActivity(intent2);
            } else {
                this.mInterstitialAd.show();
            }
            this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.2
                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    Intent intent3 = new Intent(NetwoksListActivity.this, NetworkOptionsActivity.class);
                    intent3.putExtra("title", "Telenor");
                    NetwoksListActivity.this.startActivity(intent3);
                }
            });
        } else if (view == findViewById(R.id.ufoneBtn)) {
            InterstitialAd interstitialAd3 = this.mInterstitialAd;
            if (interstitialAd3 == null || !interstitialAd3.isLoaded()) {
                Intent intent3 = new Intent(this, NetworkOptionsActivity.class);
                intent3.putExtra("title", "Ufone");
                startActivity(intent3);
            } else {
                this.mInterstitialAd.show();
            }
            this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.3
                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    Intent intent4 = new Intent(NetwoksListActivity.this, NetworkOptionsActivity.class);
                    intent4.putExtra("title", "Ufone");
                    NetwoksListActivity.this.startActivity(intent4);
                }
            });
        } else if (view == findViewById(R.id.zongBtn)) {
            InterstitialAd interstitialAd4 = this.mInterstitialAd;
            if (interstitialAd4 == null || !interstitialAd4.isLoaded()) {
                Intent intent4 = new Intent(this, NetworkOptionsActivity.class);
                intent4.putExtra("title", "Zong");
                startActivity(intent4);
            } else {
                this.mInterstitialAd.show();
            }
            this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.4
                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    Intent intent5 = new Intent(NetwoksListActivity.this, NetworkOptionsActivity.class);
                    intent5.putExtra("title", "Zong");
                    NetwoksListActivity.this.startActivity(intent5);
                }
            });
        } else if (view == findViewById(R.id.myAddedBtn)) {
            InterstitialAd interstitialAd5 = this.mInterstitialAd;
            if (interstitialAd5 == null || !interstitialAd5.isLoaded()) {
                startActivity(new Intent(this, MyAddedActivity.class));
            } else {
                this.mInterstitialAd.show();
            }
            this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.5
                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    NetwoksListActivity.this.startActivity(new Intent(NetwoksListActivity.this, MyAddedActivity.class));
                }
            });
        }
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
            this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.6
                @Override // com.google.android.gms.ads.AdListener
                public void onAdClosed() {
                    NetwoksListActivity.this.startActivity(new Intent(NetwoksListActivity.this, AboutActivity.class));
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
            } else if (itemId == R.id.action_addjazwar) {
                InterstitialAd interstitialAd2 = this.mInterstitialAd;
                if (interstitialAd2 == null || !interstitialAd2.isLoaded()) {
                    Intent intent = new Intent(this, MyAddActivity.class);
                    intent.putExtra("tableName", "JazzWarid");
                    startActivity(intent);
                } else {
                    this.mInterstitialAd.show();
                }
                this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.7
                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdClosed() {
                        Intent intent2 = new Intent(NetwoksListActivity.this, MyAddActivity.class);
                        intent2.putExtra("tableName", "JazzWarid");
                        NetwoksListActivity.this.startActivity(intent2);
                    }
                });
            } else if (itemId == R.id.action_addtelenor) {
                InterstitialAd interstitialAd3 = this.mInterstitialAd;
                if (interstitialAd3 == null || !interstitialAd3.isLoaded()) {
                    Intent intent2 = new Intent(this, MyAddActivity.class);
                    intent2.putExtra("tableName", "Telenor");
                    startActivity(intent2);
                } else {
                    this.mInterstitialAd.show();
                }
                this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.8
                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdClosed() {
                        Intent intent3 = new Intent(NetwoksListActivity.this, MyAddActivity.class);
                        intent3.putExtra("tableName", "Telenor");
                        NetwoksListActivity.this.startActivity(intent3);
                    }
                });
            } else if (itemId == R.id.action_addufone) {
                InterstitialAd interstitialAd4 = this.mInterstitialAd;
                if (interstitialAd4 == null || !interstitialAd4.isLoaded()) {
                    Intent intent3 = new Intent(this, MyAddActivity.class);
                    intent3.putExtra("tableName", "Ufone");
                    startActivity(intent3);
                } else {
                    this.mInterstitialAd.show();
                }
                this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.9
                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdClosed() {
                        Intent intent4 = new Intent(NetwoksListActivity.this, MyAddActivity.class);
                        intent4.putExtra("tableName", "Ufone");
                        NetwoksListActivity.this.startActivity(intent4);
                    }
                });
            } else if (itemId == R.id.action_addzong) {
                InterstitialAd interstitialAd5 = this.mInterstitialAd;
                if (interstitialAd5 == null || !interstitialAd5.isLoaded()) {
                    Intent intent4 = new Intent(this, MyAddActivity.class);
                    intent4.putExtra("tableName", "Zong");
                    startActivity(intent4);
                } else {
                    this.mInterstitialAd.show();
                }
                this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.NetwoksListActivity.10
                    @Override // com.google.android.gms.ads.AdListener
                    public void onAdClosed() {
                        Intent intent5 = new Intent(NetwoksListActivity.this, MyAddActivity.class);
                        intent5.putExtra("tableName", "Zong");
                        NetwoksListActivity.this.startActivity(intent5);
                    }
                });
            }
            return super.onOptionsItemSelected(menuItem);
        }
    }


        }




