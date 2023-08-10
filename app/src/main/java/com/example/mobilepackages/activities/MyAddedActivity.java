package com.example.mobilepackages.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.mobilepackages.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MyAddedActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_added);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        setSupportActionBar(toolbar);
        this.toolbar.setTitle("My Added Packages");
        this.toolbar.setSubtitle("JazzWarid");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
//        findViewById(R.id.coordinator);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() { // from class: com.blogspot.atifsoftwares.mobilepackagespakistan.activities.MyAddedActivity.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                String str = "" + tab.getText().toString();
                SharedPreferences.Editor edit = MyAddedActivity.this.getSharedPreferences("MyAdded", 0).edit();
                edit.putString("tableName", str);
                edit.apply();
                MyAddedActivity.this.toolbar.setSubtitle(str);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                MyAddedActivity.this.toolbar.setSubtitle(tab.getText());
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 1);
     //   viewPagerAdapter.addFragment(new JazWarFragment(), "JazzWarid");
//        viewPagerAdapter.addFragment(new TelenorFragment(), "Telenor");
//        viewPagerAdapter.addFragment(new UfoneFragment(), "Ufone");
//        viewPagerAdapter.addFragment(new ZongFragment(), "Zong");
        viewPager.setAdapter(viewPagerAdapter);
    }

    /* loaded from: classes.dex */
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList();
        private final List<String> fragmentTitleList = new ArrayList();


        ViewPagerAdapter(FragmentManager fragmentManager, int i) {
            super(fragmentManager);
           // MyAddedActivity.this = r1;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.fragmentList.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.fragmentList.size();
        }

        void addFragment(Fragment fragment, String str) {
            this.fragmentList.add(fragment);
            this.fragmentTitleList.add(str);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.fragmentTitleList.get(i);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}