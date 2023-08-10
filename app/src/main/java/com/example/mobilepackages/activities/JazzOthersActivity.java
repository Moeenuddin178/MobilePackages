package com.example.mobilepackages.activities;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilepackages.R;
import com.example.mobilepackages.Utils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import androidx.appcompat.app.AlertDialog;


public class JazzOthersActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;

    private void showLoadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinearLayout linearLayout = new LinearLayout(this);
        TextView textView = new TextView(this);
        final EditText mInputEt = new EditText(this);
        textView.setText("Card Load");
        textView.setTextSize(2, 16.0F);
        textView.setSingleLine();
        textView.setHint("Enter 14 Digit Number");
        textView.setInputType(3);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(textView);
        linearLayout.addView(textView);
        linearLayout.setPadding(50, 40, 50, 10);
        builder.setView(linearLayout);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) { Toast.makeText(JazzOthersActivity.this, "Canceled", Toast.LENGTH_SHORT).show(); }
        });
        builder.setPositiveButton("Dial", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("*123*");
                stringBuilder.append(mInputEt.getText().toString().trim());
                stringBuilder.append("#");
                String str = stringBuilder.toString();
                Utils.dial(JazzOthersActivity.this, str);
            }
        });
        builder.create().show();
    }

    private void showShareBlncDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinearLayout linearLayout = new LinearLayout(this);
        TextView textView = new TextView(this);
        final EditText mNumberEt = new EditText(this);
        final EditText mAmount = new EditText(this);
        textView.setText("Balance Share");
        textView.setTextSize(2, 16.0F);
        textView.setSingleLine();
        textView.setHint("Number e.g. 03XXXXXXXXX");
        textView.setInputType(3);
        textView.setSingleLine();
        textView.setHint("Amount e.g. 30");
        textView.setInputType(3);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(textView);
        linearLayout.addView(textView);
        linearLayout.addView(textView);
        linearLayout.setPadding(50, 40, 50, 10);
        builder.setView(linearLayout);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) { Toast.makeText(JazzOthersActivity.this, "Canceled", Toast.LENGTH_SHORT).show(); }
        });
        builder.setPositiveButton("Dial", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("*100*");
                stringBuilder.append(mNumberEt.getText().toString().trim());
                stringBuilder.append("*");
                stringBuilder.append(mAmount.getText().toString().trim());
                stringBuilder.append("#");
                String str = stringBuilder.toString();
                Utils.dial(JazzOthersActivity.this, str);
            }
        });
        builder.create().show();
    }

    public void A(View paramView) { if (paramView == findViewById(R.id.Acheck)) {
        Utils.dial(this, "*111#");
        return;
    }
        if (paramView == findViewById(R.id.Aload )) {
            showLoadDialog();
            return;
        }
        if (paramView == findViewById(R.id.Ashare)) {
            Toast.makeText(this, "*100*number*amount#", Toast.LENGTH_SHORT).show();
            showShareBlncDialog();
            return;
        }
        if (paramView == findViewById(R.id.Aloan)) {
            Utils.dial(this, "*112#");
            return;
        }
        if (paramView == findViewById(R.id.AchkNum)) {
            Utils.dial(this, "*99#");
            return;
        }
        if (paramView == findViewById(R.id.Ahelpline)) {
            Utils.dial(this, "111");
            return;
        }
        if (paramView == findViewById(R.id.Abima))
            Utils.dial(this, "9878");  }

    public void B(View paramView) { if (paramView == findViewById(R.id.Bact)) {
        Utils.dial(this, "*551#");
        return;
    }
        if (paramView == findViewById(R.id.Binfo)) {
            Utils.dial(this, "*551*3#");
            return;
        }
        if (paramView == findViewById(R.id.Brem))
            Utils.dial(this, "*553*2#");  }

    public void C(View paramView) { if (paramView == findViewById(R.id.Cact))
        Utils.dial(this, "*191#");  }

    public void D(View paramView) { if (paramView == findViewById(R.id.Dact))
        Utils.dial(this, "*443*7#");  }

    public void E(View paramView) { if (paramView == findViewById(R.id.eBlock))
        Utils.dial(this, "*420#");  }

    protected void onCreate(Bundle paramBundle) { super.onCreate(paramBundle);
        setContentView(R.layout.activity_jazz_others);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Jazz Others");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        this.mInterstitialAd = new InterstitialAd(this);
        this.mInterstitialAd.setAdUnitId("ca-app-pub-8967464574011121/3523145996");
        this.mInterstitialAd.loadAd((new AdRequest.Builder()).addTestDevice(getString(R.string.oppo_test_id)).build()); }

    public boolean onCreateOptionsMenu(Menu paramMenu) { getMenuInflater().inflate(R.menu.main_menu, paramMenu);
        paramMenu.findItem(2131296303).setVisible(false);
        paramMenu.findItem(2131296314).setVisible(false);
        return true; }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        int i = paramMenuItem.getItemId();
        if (i == 2131296280) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        if (i == 2131296302)
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.blogspot.atifsoftwares.mobilepackagespakistan")));
                return true;
            } catch (ActivityNotFoundException paramMenuIte) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.blogspot.atifsoftwares.mobilepackagespakistan")));
                return true;
            }
        if (i == 2131296301)
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/dev?id=6868537621115215530")));
                return true;
            } catch (ActivityNotFoundException paramMenuIte) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/dev?id=6868537621115215530")));
                return true;
            }
        if (i == 2131296304) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "Subject Here");
            startActivity(intent.putExtra("android.intent.extra.TEXT", "\"Mobile Packages Pakistan\" app contains all packages of all networks of Pakistan. You can Activate, Deactivate or Remaining also you can check.:\n https://play.google.com/store/apps/details?id=com.blogspot.atifsoftwares.mobilepackagespakistan").createChooser(intent, "Share via"));
        } else if (i == 2131296281) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent = new Intent(this, MyAddActivity.class);
                intent.putExtra("tableName", "JazzWarid");
                startActivity(intent);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(JazzOthersActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "JazzWarid");
                    JazzOthersActivity.this.startActivity(intent);
                }
            });
        } else if (i == 2131296282) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent = new Intent(this, MyAddActivity.class);
                intent.putExtra("tableName", "Telenor");
                startActivity(intent);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(JazzOthersActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Telenor");
                    JazzOthersActivity.this.startActivity(intent);
                }
            });
        } else if (i == 2131296283) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent = new Intent(this, MyAddActivity.class);
                intent.putExtra("tableName", "Ufone");
                startActivity(intent);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(JazzOthersActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Ufone");
                    JazzOthersActivity.this.startActivity(intent);
                }
            });
        } else if (i == 2131296284) {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent = new Intent(this, MyAddActivity.class);
                intent.putExtra("tableName", "Zong");
                startActivity(intent);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(JazzOthersActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Zong");
                    JazzOthersActivity.this.startActivity(intent);
                }
            });
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public boolean onSupportNavigateUp() { onBackPressed();
        return true; }
}