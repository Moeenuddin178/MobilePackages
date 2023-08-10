//package com.example.mobilepackages.fragments;
//
//import android.content.Intent;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RelativeLayout;
//
//import androidx.appcompat.widget.SearchView;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.mobilepackages.R;
//import com.example.mobilepackages.Utils;
//import com.example.mobilepackages.activities.AboutActivity;
//import com.example.mobilepackages.activities.MyAddActivity;
//import com.example.mobilepackages.databases.MyDbHelper;
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;
//
//import java.util.ArrayList;
//
//public class JazWarFragment extends Fragment {
//    private AdapterMyPackage adapterMyPackage;
//    private InterstitialAd mInterstitialAd;
//    private MyDbHelper mSQLiteHelper;
//    private ArrayList<ModelMyPackage> myPackageList;
//    private RecyclerView myPkgsRv;
//    private RelativeLayout relativeLayout;
//    private String tableName = "JazzWarid";
//
//    @Override // androidx.fragment.app.Fragment
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        View inflate = layoutInflater.inflate(R.layout.fragment_jaz_war, viewGroup, false);
//        this.myPkgsRv = (RecyclerView) inflate.findViewById(R.id.myPkgsRv);
//        this.relativeLayout = (RelativeLayout) inflate.findViewById(R.id.relLayout);
//        InterstitialAd interstitialAd = new InterstitialAd(getActivity());
//        this.mInterstitialAd = interstitialAd;
//        interstitialAd.setAdUnitId(getString(R.string.interstitial_id1));
//        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
//        MyDbHelper myDbHelper = new MyDbHelper(getActivity(), "RECORDDB.sqlite", null, 1);
//        this.mSQLiteHelper = myDbHelper;
//        myDbHelper.queryData("CREATE TABLE IF NOT EXISTS " + this.tableName + "(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
//        new ShowPackagesAsync().execute(new String[0]);
//        return inflate;
//    }
//
//    /* loaded from: classes.dex */
//    private class ShowPackagesAsync extends AsyncTask<String, String, ArrayList<ModelMyPackage>> {
//        private ShowPackagesAsync() {
//            JazWarFragment.this = r1;
//        }
//
//        public ArrayList<ModelMyPackage> doInBackground(String... strArr) {
//            JazWarFragment.this.myPackageList = new ArrayList();
//            MyDbHelper myDbHelper = JazWarFragment.this.mSQLiteHelper;
//            Cursor data = myDbHelper.getData("SELECT * FROM  " + JazWarFragment.this.tableName);
//            JazWarFragment.this.myPackageList.clear();
//            while (data.moveToNext()) {
//                JazWarFragment.this.myPackageList.add(new ModelMyPackage(data.getInt(0), data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7)));
//            }
//            return JazWarFragment.this.myPackageList;
//        }
//
//        public void onPostExecute(ArrayList<ModelMyPackage> arrayList) {
//            super.onPostExecute((ShowPackagesAsync) arrayList);
//            Log.d("PackageList", "Count:" + arrayList.size());
//            JazWarFragment jazWarFragment = JazWarFragment.this;
//            jazWarFragment.adapterMyPackage = new AdapterMyPackage(jazWarFragment.getActivity(), arrayList);
//            JazWarFragment.this.myPkgsRv.setAdapter(JazWarFragment.this.adapterMyPackage);
//            if (arrayList.size() == 0) {
//                JazWarFragment.this.relativeLayout.setVisibility(0);
//                JazWarFragment.this.myPkgsRv.setVisibility(8);
//            }
//        }
//    }
//
//    @Override // androidx.fragment.app.Fragment
//    public void onResume() {
//        new ShowPackagesAsync().execute(new String[0]);
//        super.onResume();
//    }
//
//    @Override // androidx.fragment.app.Fragment
//    public void onCreate(Bundle bundle) {
//        setHasOptionsMenu(true);
//        super.onCreate(bundle);
//    }
//
//    @Override // androidx.fragment.app.Fragment
//    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
//        menuInflater.inflate(R.menu.main_menu, menu);
//        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
//        searchView.setQueryHint("Search Title | Price | Code");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.fragments.JazWarFragment.1
//            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
//            public boolean onQueryTextSubmit(String str) {
//                return false;
//            }
//
//            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
//            public boolean onQueryTextChange(String str) {
//                JazWarFragment.this.adapterMyPackage.getFilter().filter(str);
//                return false;
//            }
//        });
//    }
//
//    @Override // androidx.fragment.app.Fragment
//    public boolean onOptionsItemSelected(MenuItem menuItem) {
//        int itemId = menuItem.getItemId();
//        if (itemId == R.id.action_about) {
//            InterstitialAd interstitialAd = this.mInterstitialAd;
//            if (interstitialAd == null || !interstitialAd.isLoaded()) {
//                startActivity(new Intent(getActivity(), AboutActivity.class));
//            } else {
//                this.mInterstitialAd.show();
//            }
//            this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.fragments.JazWarFragment.2
//                @Override // com.google.android.gms.ads.AdListener
//                public void onAdClosed() {
//                    JazWarFragment.this.startActivity(new Intent(JazWarFragment.this.getActivity(), AboutActivity.class));
//                }
//            });
//            return true;
//        } else if (itemId == R.id.action_rate) {
//            Utils.rateApp(getActivity());
//            return true;
//        } else if (itemId == R.id.action_moreapps) {
//            Utils.moreApps(getActivity());
//            return true;
//        } else {
//            if (itemId == R.id.action_share) {
//                Utils.shareApp(getActivity());
//            } else if (itemId == R.id.action_addjazwar) {
//                InterstitialAd interstitialAd2 = this.mInterstitialAd;
//                if (interstitialAd2 == null || !interstitialAd2.isLoaded()) {
//                    Intent intent = new Intent(getActivity(), MyAddActivity.class);
//                    intent.putExtra("tableName", "JazzWarid");
//                    startActivity(intent);
//                } else {
//                    this.mInterstitialAd.show();
//                }
//                this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.fragments.JazWarFragment.3
//                    @Override // com.google.android.gms.ads.AdListener
//                    public void onAdClosed() {
//                        Intent intent2 = new Intent(JazWarFragment.this.getActivity(), MyAddActivity.class);
//                        intent2.putExtra("tableName", "JazzWarid");
//                        JazWarFragment.this.startActivity(intent2);
//                    }
//                });
//            } else if (itemId == R.id.action_addtelenor) {
//                InterstitialAd interstitialAd3 = this.mInterstitialAd;
//                if (interstitialAd3 == null || !interstitialAd3.isLoaded()) {
//                    Intent intent2 = new Intent(getActivity(), MyAddActivity.class);
//                    intent2.putExtra("tableName", "Telenor");
//                    startActivity(intent2);
//                } else {
//                    this.mInterstitialAd.show();
//                }
//                this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.fragments.JazWarFragment.4
//                    @Override // com.google.android.gms.ads.AdListener
//                    public void onAdClosed() {
//                        Intent intent3 = new Intent(JazWarFragment.this.getActivity(), MyAddActivity.class);
//                        intent3.putExtra("tableName", "Telenor");
//                        JazWarFragment.this.startActivity(intent3);
//                    }
//                });
//            } else if (itemId == R.id.action_addufone) {
//                InterstitialAd interstitialAd4 = this.mInterstitialAd;
//                if (interstitialAd4 == null || !interstitialAd4.isLoaded()) {
//                    Intent intent3 = new Intent(getActivity(), MyAddActivity.class);
//                    intent3.putExtra("tableName", "Ufone");
//                    startActivity(intent3);
//                } else {
//                    this.mInterstitialAd.show();
//                }
//                this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.fragments.JazWarFragment.5
//                    @Override // com.google.android.gms.ads.AdListener
//                    public void onAdClosed() {
//                        Intent intent4 = new Intent(JazWarFragment.this.getActivity(), MyAddActivity.class);
//                        intent4.putExtra("tableName", "Ufone");
//                        JazWarFragment.this.startActivity(intent4);
//                    }
//                });
//            } else if (itemId == R.id.action_addzong) {
//                InterstitialAd interstitialAd5 = this.mInterstitialAd;
//                if (interstitialAd5 == null || !interstitialAd5.isLoaded()) {
//                    Intent intent4 = new Intent(getActivity(), MyAddActivity.class);
//                    intent4.putExtra("tableName", "Zong");
//                    startActivity(intent4);
//                } else {
//                    this.mInterstitialAd.show();
//                }
//                this.mInterstitialAd.setAdListener(new AdListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.fragments.JazWarFragment.6
//                    @Override // com.google.android.gms.ads.AdListener
//                    public void onAdClosed() {
//                        Intent intent5 = new Intent(JazWarFragment.this.getActivity(), MyAddActivity.class);
//                        intent5.putExtra("tableName", "Zong");
//                        JazWarFragment.this.startActivity(intent5);
//                    }
//                });
//            }
//            return super.onOptionsItemSelected(menuItem);
//        }
//    }
//}