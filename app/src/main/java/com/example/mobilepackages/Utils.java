package com.example.mobilepackages;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import android.content.ClipboardManager;

public class Utils extends Application {

    public static void moreApps(Context paramContext) {
        try {
            paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/dev?id=6868537621115215530")));
            return;
        } catch (ActivityNotFoundException activityNotFoundException) {
            paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/dev?id=6868537621115215530")));
            return;
        }
    }

    public static void privacyPolicy(Context paramContext) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://atifsoftwares.blogspot.com/p/mobile-packages-pakistan-privacy-policy.html"));
        paramContext.startActivity(intent);
    }

    public static void rateApp(Context paramContext) {
        try {
            paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.blogspot.atifsoftwares.mobilepackagespakistan")));
            return;
        } catch (ActivityNotFoundException activityNotFoundException) {
            paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.blogspot.atifsoftwares.mobilepackagespakistan")));
            return;
        }
    }

    public static void shareApp(Context paramContext) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "Subject Here");
        paramContext.startActivity(intent.putExtra("android.intent.extra.TEXT", "\"Mobile Packages Pakistan\" app contains all packages of all networks of Pakistan. You can Activate, Deactivate or Remaining also you can check.:\n https://play.google.com/store/apps/details?id=com.blogspot.atifsoftwares.mobilepackagespakistan").createChooser(intent, "Share via"));
    }

    public static void shareText(Context paramContext, String paramString) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "Subject Here");
        paramContext.startActivity(intent.putExtra("android.intent.extra.TEXT", paramString).createChooser(intent, "Share via..."));
    }

    public static void website(Context paramContext) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://atifsoftwares.blogspot.com"));
        paramContext.startActivity(intent);
    }

    public static void copyText(Context paramContext, String paramString) {
        ((ClipboardManager) paramContext.getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("label", paramString));
        Toast.makeText(paramContext, "Copied...", Toast.LENGTH_SHORT).show();
    }


    public static void dial(Context paramContext, String paramString) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tel:");
        stringBuilder.append(Uri.encode(paramString));
        paramContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(stringBuilder.toString())));
        Toast.makeText(paramContext, paramString, Toast.LENGTH_SHORT).show();
    }

    public void onCreate() {
        super.onCreate();
    }
}
