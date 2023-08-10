package com.example.mobilepackages.activities;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobilepackages.R;
import com.example.mobilepackages.Utils;
import com.example.mobilepackages.adapter.ListAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class NetworkOptionsActivity extends AppCompatActivity {
    private static final String DB_NAME = "Database";

    Intent intent;
    private ListAdapter listAdapter;
    //private DataBaseHelper mDbHelper;
    InterstitialAd mInterstitialAd;
    private ListView mListView;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_options);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("Choose package type...");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        this.intent = getIntent();
        this.title = this.intent.getStringExtra("title");
        this.mInterstitialAd = new InterstitialAd(this);
        this.mInterstitialAd.setAdUnitId("ca-app-pub-8967464574011121/9957454106");
        this.mInterstitialAd.loadAd((new AdRequest.Builder()).addTestDevice(getString(R.string.oppo_test_id)).build());
        actionBar.setTitle(this.title);

    }
    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(R.menu.main_menu, paramMenu);
        paramMenu.findItem(R.id.action_search).setVisible(false);
        return true; }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        InterstitialAd interstitialAd = null;
        int i = paramMenuItem.getItemId();
        if (i == R.id.action_about) {
            interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                startActivity(new Intent(this, AboutActivity.class));
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    NetworkOptionsActivity networkOptionsActivity = NetworkOptionsActivity.this;
                    networkOptionsActivity.startActivity(new Intent(networkOptionsActivity, AboutActivity.class));
                }
            });
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
        } else if (i == R.id.action_addjazwar ) {
            InterstitialAd interstitialAd1 = this.mInterstitialAd;
            if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent1 = new Intent(this, MyAddActivity.class);
                intent1.putExtra("tableName", "JazzWarid");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "JazzWarid");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
        } else if (i == R.id.action_addtelenor ) {
            InterstitialAd interstitialAd1 = this.mInterstitialAd;
            if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent1 = new Intent(this, MyAddActivity.class);
                intent1.putExtra("tableName", "Telenor");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Telenor");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
        } else if (i == R.id.action_addufone ) {
            InterstitialAd interstitialAd1 = this.mInterstitialAd;
            if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent1 = new Intent(this, MyAddActivity.class);
                intent1.putExtra("tableName", "Ufone");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Ufone");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
        } else if (i == R.id.action_addzong  ) {
            InterstitialAd interstitialAd1 = this.mInterstitialAd;
            if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent1 = new Intent(this, MyAddActivity.class);
                intent1.putExtra("tableName", "Zong");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, MyAddActivity.class);
                    intent.putExtra("tableName", "Zong");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public boolean onSupportNavigateUp() { onBackPressed();
        return true; }


    public void pkg(View paramView) {
        Intent intent1 = null;
        View view = findViewById(R.id.callBtn);
        View view1 = findViewById(R.id.smsBtn);
        View view2 = findViewById(R.id.netBtn);
        View view3 = findViewById(R.id.allBtn);
        View view4= findViewById(R.id.broadBtn);
        View view5 = findViewById(R.id.othersBtn);
        byte b = -1;
        if (paramView == view) {
            String str = this.title;
            switch (str.hashCode()) {
                case 235300551:
                    if (str.equals("Telenor"))
                        b = 1;
                    break;
                case 83348963:
                    if (str.equals("Warid"))
                        b = 3;
                    break;
                case 81648149:
                    if (str.equals("Ufone"))
                        b = 2;
                    break;
                case 2791374:
                    if (str.equals("Zong"))
                        b = 4;
                    break;
                case 2301655:
                    if (str.equals("Jazz"))
                        b = 0;
                    break;
            }
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4)
                                return;
                            InterstitialAd interstitialAd3 = this.mInterstitialAd;
                            if (interstitialAd3 != null && interstitialAd3.isLoaded()) {
                                this.mInterstitialAd.show();
                            } else {
                                Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                                intent2.putExtra("title", "Zong Call");
                                startActivity(intent2);
                            }
                            this.mInterstitialAd.setAdListener(new AdListener() {
                                public void onAdClosed() {
                                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                    intent.putExtra("title", "Zong Call");
                                    NetworkOptionsActivity.this.startActivity(intent);
                                }
                            });
                            return;
                        }
                        InterstitialAd interstitialAd2 = this.mInterstitialAd;
                        if (interstitialAd2 != null && interstitialAd2.isLoaded()) {
                            this.mInterstitialAd.show();
                        } else {
                            Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                            intent2.putExtra("title", "Warid Call");
                            startActivity(intent2);
                        }
                        this.mInterstitialAd.setAdListener(new AdListener() {
                            public void onAdClosed() {
                                Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                intent.putExtra("title", "Warid Call");
                                NetworkOptionsActivity.this.startActivity(intent);
                            }
                        });
                        return;
                    }
                    InterstitialAd interstitialAd1 = this.mInterstitialAd;
                    if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                        this.mInterstitialAd.show();
                    } else {
                        Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                        intent2.putExtra("title", "Ufone Call");
                        startActivity(intent2);
                    }
                    this.mInterstitialAd.setAdListener(new AdListener() {
                        public void onAdClosed() {
                            Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                            intent.putExtra("title", "Ufone Call");
                            NetworkOptionsActivity.this.startActivity(intent);
                        }
                    });
                    return;
                }
                InterstitialAd interstitialAd = this.mInterstitialAd;
                if (interstitialAd != null && interstitialAd.isLoaded()) {
                    this.mInterstitialAd.show();
                } else {
                    Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                    intent2.putExtra("title", "Telenor Call");
                    startActivity(intent2);
                }
                this.mInterstitialAd.setAdListener(new AdListener() {
                    public void onAdClosed() {
                        Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                        intent.putExtra("title", "Telenor Call");
                        NetworkOptionsActivity.this.startActivity(intent);
                    }
                });
                return;
            }
           mInterstitialAd = this.mInterstitialAd;
            if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent2;
                intent1 = new Intent(this, NetworkOptionDetailActivity.class);
                intent1.putExtra("title", "Jazz Call");
                startActivity(intent1);
                this.intent=intent1;
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                    intent.putExtra("title", "Jazz Call");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
            return;
        }
      if (paramView==view1) {
            String str = this.title;
            switch (str.hashCode()) {
                case 235300551:
                    if (str.equals("Telenor"))
                        b = 1;
                    break;
                case 83348963:
                    if (str.equals("Warid"))
                        b = 3;
                    break;
                case 81648149:
                    if (str.equals("Ufone"))
                        b = 2;
                    break;
                case 2791374:
                    if (str.equals("Zong"))
                        b = 4;
                    break;
                case 2301655:
                    if (str.equals("Jazz"))
                        b = 0;
                    break;
            }
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4)
                                return;
                            InterstitialAd interstitialAd4 = this.mInterstitialAd;
                            if (interstitialAd4 != null && interstitialAd4.isLoaded()) {
                                this.mInterstitialAd.show();
                            } else {
                                Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                                intent2.putExtra("title", "Zong SMS");
                                startActivity(intent2);
                            }
                            this.mInterstitialAd.setAdListener(new AdListener() {
                                public void onAdClosed() {
                                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                    intent.putExtra("title", "Zong SMS");
                                    NetworkOptionsActivity.this.startActivity(intent);
                                }
                            });
                            return;
                        }
                        InterstitialAd interstitialAd3 = this.mInterstitialAd;
                        if (interstitialAd3 != null && interstitialAd3.isLoaded()) {
                            this.mInterstitialAd.show();
                        } else {
                            Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                            intent2.putExtra("title", "Warid SMS");
                            startActivity(intent2);
                        }
                        this.mInterstitialAd.setAdListener(new AdListener() {
                            public void onAdClosed() {
                                Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                intent.putExtra("title", "Warid SMS");
                                NetworkOptionsActivity.this.startActivity(intent);
                            }
                        });
                        return;
                    }
                    InterstitialAd interstitialAd2 = this.mInterstitialAd;
                    if (interstitialAd2 != null && interstitialAd2.isLoaded()) {
                        this.mInterstitialAd.show();
                    } else {
                        Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                        intent2.putExtra("title", "Ufone SMS");
                        startActivity(intent2);
                    }
                    this.mInterstitialAd.setAdListener(new AdListener() {
                        public void onAdClosed() {
                            Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                            intent.putExtra("title", "Ufone SMS");
                            NetworkOptionsActivity.this.startActivity(intent);
                        }
                    });
                    return;
                }
                InterstitialAd interstitialAd1 = this.mInterstitialAd;
                if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                    this.mInterstitialAd.show();
                } else {
                    Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                    intent2.putExtra("title", "Telenor SMS");
                    startActivity(intent2);
                }
                this.mInterstitialAd.setAdListener(
                        new AdListener() {
                    public void onAdClosed() {
                        Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                        intent.putExtra("title", "Telenor SMS");
                        NetworkOptionsActivity.this.startActivity(intent);
                    }
                });
                return;
            }
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent2;
                intent1 = new Intent(this, NetworkOptionDetailActivity.class);
                intent1.putExtra("title", "Jazz SMS");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                    intent.putExtra("title", "Jazz SMS");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
            return;
        }


        if (paramView == view2) {
            String str = this.title;
            switch (str.hashCode()) {
                case 235300551:
                    if (str.equals("Telenor"))
                        b = 1;
                    break;
                case 83348963:
                    if (str.equals("Warid"))
                        b = 3;
                    break;
                case 81648149:
                    if (str.equals("Ufone"))
                        b = 2;
                    break;
                case 2791374:
                    if (str.equals("Zong"))
                        b = 4;
                    break;
                case 2301655:
                    if (str.equals("Jazz"))
                        b = 0;
                    break;
            }
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4)
                                return;
                            InterstitialAd interstitialAd4 = this.mInterstitialAd;
                            if (interstitialAd4 != null && interstitialAd4.isLoaded()) {
                                this.mInterstitialAd.show();
                            } else {
                                Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                                intent2.putExtra("title", "Zong Net");
                                startActivity(intent2);
                            }
                            this.mInterstitialAd.setAdListener(new AdListener() {
                                public void onAdClosed() {
                                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                    intent.putExtra("title", "Zong Net");
                                    NetworkOptionsActivity.this.startActivity(intent);
                                }
                            });
                            return;
                        }
                        InterstitialAd interstitialAd3 = this.mInterstitialAd;
                        if (interstitialAd3 != null && interstitialAd3.isLoaded()) {
                            this.mInterstitialAd.show();
                        } else {
                            Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                            intent2.putExtra("title", "Warid Net");
                            startActivity(intent2);
                        }
                        this.mInterstitialAd.setAdListener(new AdListener() {
                            public void onAdClosed() {
                                Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                intent.putExtra("title", "Warid Net");
                                NetworkOptionsActivity.this.startActivity(intent);
                            }
                        });
                        return;
                    }
                    InterstitialAd interstitialAd2 = this.mInterstitialAd;
                    if (interstitialAd2 != null && interstitialAd2.isLoaded()) {
                        this.mInterstitialAd.show();
                    } else {
                        Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                        intent2.putExtra("title", "Ufone Net");
                        startActivity(intent2);
                    }
                    this.mInterstitialAd.setAdListener(new AdListener() {
                        public void onAdClosed() {
                            Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                            intent.putExtra("title", "Ufone Net");
                            NetworkOptionsActivity.this.startActivity(intent);
                        }
                    });
                    return;
                }
                InterstitialAd interstitialAd1 = this.mInterstitialAd;
                if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                    this.mInterstitialAd.show();
                } else {
                    Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                    intent2.putExtra("title", "Telenor Net");
                    startActivity(intent2);
                }
                this.mInterstitialAd.setAdListener(new AdListener() {
                    public void onAdClosed() {
                        Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                        intent.putExtra("title", "Telenor Net");
                        NetworkOptionsActivity.this.startActivity(intent);
                    }
                });
                return;
            }
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent2;
                intent1 = new Intent(this, NetworkOptionDetailActivity.class);
                intent1.putExtra("title", "Jazz Net");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                    intent.putExtra("title", "Jazz Net");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
            return;
        }
        if (paramView == view3) {
            String str = this.title;
            switch (str.hashCode()) {
                case 235300551:
                    if (str.equals("Telenor"))
                        b = 1;
                    break;
                case 83348963:
                    if (str.equals("Warid"))
                        b = 3;
                    break;
                case 81648149:
                    if (str.equals("Ufone"))
                        b = 2;
                    break;
                case 2791374:
                    if (str.equals("Zong"))
                        b = 4;
                    break;
                case 2301655:
                    if (str.equals("Jazz"))
                        b = 0;
                    break;
            }
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4)
                                return;
                            InterstitialAd interstitialAd4 = this.mInterstitialAd;
                            if (interstitialAd4 != null && interstitialAd4.isLoaded()) {
                                this.mInterstitialAd.show();
                            } else {
                                Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                                intent2.putExtra("title", "Zong All In One");
                                startActivity(intent2);
                            }
                            this.mInterstitialAd.setAdListener(new AdListener() {
                                public void onAdClosed() {
                                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                    intent.putExtra("title", "Zong All In One");
                                    NetworkOptionsActivity.this.startActivity(intent);
                                }
                            });
                            return;
                        }
                        InterstitialAd interstitialAd3 = this.mInterstitialAd;
                        if (interstitialAd3 != null && interstitialAd3.isLoaded()) {
                            this.mInterstitialAd.show();
                        } else {
                            Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                            intent2.putExtra("title", "Warid All In One");
                            startActivity(intent2);
                        }
                        this.mInterstitialAd.setAdListener(new AdListener() {
                            public void onAdClosed() {
                                Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                intent.putExtra("title", "Warid All In One");
                                NetworkOptionsActivity.this.startActivity(intent);
                            }
                        });
                        return;
                    }
                    InterstitialAd interstitialAd2 = this.mInterstitialAd;
                    if (interstitialAd2 != null && interstitialAd2.isLoaded()) {
                        this.mInterstitialAd.show();
                    } else {
                        Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                        intent2.putExtra("title", "Ufone All In One");
                        startActivity(intent2);
                    }
                    this.mInterstitialAd.setAdListener(new AdListener() {
                        public void onAdClosed() {
                            Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                            intent.putExtra("title", "Ufone All In One");
                            NetworkOptionsActivity.this.startActivity(intent);
                        }
                    });
                    return;
                }
                InterstitialAd interstitialAd1 = this.mInterstitialAd;
                if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                    this.mInterstitialAd.show();
                } else {
                    Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                    intent2.putExtra("title", "Telenor All In One");
                    startActivity(intent2);
                }
                this.mInterstitialAd.setAdListener(new AdListener() {
                    public void onAdClosed() {
                        Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                        intent.putExtra("title", "Telenor All In One");
                        NetworkOptionsActivity.this.startActivity(intent);
                    }
                });
                return;
            }
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                Intent intent2;
                intent1 = new Intent(this, NetworkOptionDetailActivity.class);
                intent1.putExtra("title", "Jazz All In One");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                    intent.putExtra("title", "Jazz All In One");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
            return;
        }
        if (paramView == view4) {
            String str = this.title;
            switch (str.hashCode()) {
                case 235300551:
                    if (str.equals("Telenor"))
                        b = 1;
                    break;
                case 83348963:
                    if (str.equals("Warid"))
                        b = 3;
                    break;
                case 81648149:
                    if (str.equals("Ufone"))
                        b = 2;
                    break;
                case 2791374:
                    if (str.equals("Zong"))
                        b = 4;
                    break;
                case 2301655:
                    if (str.equals("Jazz"))
                        b = 0;
                    break;
            }
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4)
                                return;
                            InterstitialAd interstitialAd3 = this.mInterstitialAd;
                            if (interstitialAd3 != null && interstitialAd3.isLoaded()) {
                                this.mInterstitialAd.show();
                            } else {
                                Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                                intent2.putExtra("title", "Zong Broadband");
                                startActivity(intent2);
                            }
                            this.mInterstitialAd.setAdListener(new AdListener() {
                                public void onAdClosed() {
                                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                    intent.putExtra("title", "Zong Broadband");
                                    NetworkOptionsActivity.this.startActivity(intent);
                                }
                            });
                            return;
                        }
                        InterstitialAd interstitialAd2 = this.mInterstitialAd;
                        if (interstitialAd2 != null && interstitialAd2.isLoaded()) {
                            this.mInterstitialAd.show();
                        } else {
                            Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                            intent2.putExtra("title", "Warid Broadband");
                            startActivity(intent2);
                        }
                        this.mInterstitialAd.setAdListener(new AdListener() {
                            public void onAdClosed() {
                                Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                                intent.putExtra("title", "Warid Broadband");
                                NetworkOptionsActivity.this.startActivity(intent);
                            }
                        });
                        return;
                    }
                    Toast.makeText(this, "Currently not available...", Toast.LENGTH_SHORT).show();
                    return;
                }
                InterstitialAd interstitialAd1 = this.mInterstitialAd;
                if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                    this.mInterstitialAd.show();
                } else {
                    Intent intent2 = new Intent(this, NetworkOptionDetailActivity.class);
                    intent2.putExtra("title", "Telenor Broadband");
                    startActivity(intent2);
                }
                this.mInterstitialAd.setAdListener(new AdListener() {
                    public void onAdClosed() {
                        Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                        intent.putExtra("title", "Telenor Broadband");
                        NetworkOptionsActivity.this.startActivity(intent);
                    }
                });
                return;
            }
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                intent1 = new Intent(this, NetworkOptionDetailActivity.class);
                intent1.putExtra("title", "Jazz Broadband");
                startActivity(intent1);
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    Intent intent = new Intent(NetworkOptionsActivity.this, NetworkOptionDetailActivity.class);
                    intent.putExtra("title", "Jazz Broadband");
                    NetworkOptionsActivity.this.startActivity(intent);
                }
            });
            return;
        }
        if (paramView == view5) {
            String str = this.title;
            switch (str.hashCode()) {
                case 235300551:
                    if (str.equals("Telenor"))
                        b = 1;
                    break;
                case 83348963:
                    if (str.equals("Warid"))
                        b = 3;
                    break;
                case 81648149:
                    if (str.equals("Ufone"))
                        b = 2;
                    break;
                case 2791374:
                    if (str.equals("Zong"))
                        b = 4;
                    break;
                case 2301655:
                    if (str.equals("Jazz"))
                        b = 0;
                    break;
            }
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4)
                                return;
                            InterstitialAd interstitialAd4 = this.mInterstitialAd;
                            if (interstitialAd4 != null && interstitialAd4.isLoaded()) {
                                this.mInterstitialAd.show();
                            } else {
                                startActivity(new Intent(this, ZongOthersActivity.class));
                            }
                            this.mInterstitialAd.setAdListener(new AdListener() {
                                public void onAdClosed() {
                                    NetworkOptionsActivity networkOptionsActivity = NetworkOptionsActivity.this;
                                    networkOptionsActivity.startActivity(new Intent(networkOptionsActivity, ZongOthersActivity.class));
                                }
                            });
                            return;
                        }
                        InterstitialAd interstitialAd3 = this.mInterstitialAd;
                        if (interstitialAd3 != null && interstitialAd3.isLoaded()) {
                            this.mInterstitialAd.show();
                        } else {
                            startActivity(new Intent(this, JazzOthersActivity.class));
                        }
                        this.mInterstitialAd.setAdListener(new AdListener() {
                            public void onAdClosed() {
                                NetworkOptionsActivity networkOptionsActivity = NetworkOptionsActivity.this;
                                networkOptionsActivity.startActivity(new Intent(networkOptionsActivity, JazzOthersActivity.class));
                            }
                        });
                        return;
                    }
                    InterstitialAd interstitialAd2 = this.mInterstitialAd;
                    if (interstitialAd2 != null && interstitialAd2.isLoaded()) {
                        this.mInterstitialAd.show();
                    } else {
                        startActivity(new Intent(this, UfoneOthersActivity.class));
                    }
                    this.mInterstitialAd.setAdListener(new AdListener() {
                        public void onAdClosed() {
                            NetworkOptionsActivity networkOptionsActivity = NetworkOptionsActivity.this;
                            networkOptionsActivity.startActivity(new Intent(networkOptionsActivity, UfoneOthersActivity.class));
                        }
                    });
                    return;
                }
                InterstitialAd interstitialAd1 = this.mInterstitialAd;
                if (interstitialAd1 != null && interstitialAd1.isLoaded()) {
                    this.mInterstitialAd.show();
                } else {
                    startActivity(new Intent(this, TelenorOthersActivity.class));
                }
                this.mInterstitialAd.setAdListener(new AdListener() {
                    public void onAdClosed() {
                        NetworkOptionsActivity networkOptionsActivity = NetworkOptionsActivity.this;
                        networkOptionsActivity.startActivity(new Intent(networkOptionsActivity, TelenorOthersActivity.class));
                    }
                });
                return;
            }
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                this.mInterstitialAd.show();
            } else {
                startActivity(new Intent(this, JazzOthersActivity.class));
            }
            this.mInterstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    NetworkOptionsActivity networkOptionsActivity = NetworkOptionsActivity.this;
                    networkOptionsActivity.startActivity(new Intent(networkOptionsActivity, JazzOthersActivity.class));
                }
            });
        }
    }
}

