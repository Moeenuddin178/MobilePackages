package com.example.mobilepackages.adapter;
import android.content.Context;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilepackages.R;
import com.example.mobilepackages.Utils;
import com.example.mobilepackages.activities.NetworkOptionDetailActivity;
import com.example.mobilepackages.databases.MyDbHelper;
import com.example.mobilepackages.models.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListAdapter extends BaseAdapter {

    ArrayList<Model> arrayList;
    LayoutInflater inflater;
    Context mContext;
    MyDbHelper mSQLiteHelper;
    List<Model> modellist;
    String tableName;


    public ListAdapter(Context paramContext, List<Model> paramList) {
        this.mContext = paramContext;
        this.modellist = paramList;
        this.inflater = LayoutInflater.from(this.mContext);
        this.arrayList = new ArrayList();
        this.arrayList.addAll(paramList);
    }


    @Override
    public int getCount() {
        return this.modellist.size();
    }

    @Override
    public Object getItem(int position) {
        return this.modellist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        final ViewHolder holder;

        if (paramView == null) {
            paramView = LayoutInflater.from(mContext).
                    inflate(R.layout.row_pkg, paramViewGroup, false);
             holder = new ViewHolder(paramView);
            // paramView = this.inflater.inflate(R.layout.row_pkg,null );
            this.mSQLiteHelper = new MyDbHelper(this.mContext, "RECORDDB.sqlite", null, 1);
            this.mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS JazzWarid(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
            this.mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Telenor(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
            this.mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Ufone(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
            this.mSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Zong(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, duration VARCHAR, volume VARCHAR, activation VARCHAR, deactivation VARCHAR, remaining VARCHAR, price VARCHAR)");
            final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this.mContext);
            View view = LayoutInflater.from(this.mContext).inflate(R.layout.bs_pkgs, null);
            mBottomSheetDialog.setContentView(view);
            mBottomSheetDialog.setTitle("Choose");
            CardView cardView1 = (CardView) view.findViewById(R.id.copyCard);
            CardView cardView2 = (CardView) view.findViewById(R.id.shareCard);
            CardView cardView3 = (CardView) view.findViewById(R.id.copyCard);
            final ImageView favImg = (ImageView) view.findViewById(R.id.favImg);
            final TextView favTv = (TextView) view.findViewById(R.id.favTv);
            StringBuilder builder = new StringBuilder();
            builder.append("");
            builder.append(((NetworkOptionDetailActivity) this.mContext).getSupportActionBar().getTitle());
            String str = builder.toString();
            if (str.contains("Jazz")) {
                this.tableName = "JazzWarid";
            } else if (str.contains("Telenor")) {
                this.tableName = "Telenor";
            } else if (str.contains("Ufone")) {
                this.tableName = "Ufone";
            } else if (str.contains("Zong")) {
                this.tableName = "Zong";
            } else {
                Toast.makeText(this.mContext, "oh no", Toast.LENGTH_SHORT).show();
            }

            holder.mActivateBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    String str = holder.mActivationTv.getText().toString();
                   // String str = "dlkm";
                    if (str.equals("N/A")) {
                        Toast.makeText(ListAdapter.this.mContext, "N/A", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (str.contains("Send")) {
                        Toast.makeText(ListAdapter.this.mContext, str, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (str.contains("*6464")) {
                        Utils.dial(ListAdapter.this.mContext, "*6464#");
                        return;
                    }
                    Utils.dial(ListAdapter.this.mContext, str);
                }
            });
            holder.mDeactivateBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    String str = holder.mDeactivationTv.getText().toString();
                    //String str = "kjks";
                    if (str.equals("N/A")) {
                        Toast.makeText(ListAdapter.this.mContext, "N/A", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (str.contains("Send")) {
                        Toast.makeText(ListAdapter.this.mContext, str, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (str.contains("*6464")) {
                        Utils.dial(ListAdapter.this.mContext, "*6464#");
                        return;
                    }
                    Utils.dial(ListAdapter.this.mContext, str);
                }
            });
            holder.mRemainingBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    String str = holder.mRemainingTv.getText().toString();
                    //String str = "";
                    if (str.equals("N/A")) {
                        Toast.makeText(ListAdapter.this.mContext, "N/A", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (str.contains("Send")) {
                        Toast.makeText(ListAdapter.this.mContext, str, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (str.contains("*6464")) {
                        Utils.dial(ListAdapter.this.mContext, "*6464#");
                        return;
                    }
                    Utils.dial(ListAdapter.this.mContext, str);
                }
            });
            holder.mBtnMore.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                      String str = holder.mTitleTv.getText().toString();
                    //String str = "";
                    if (ListAdapter.this.mSQLiteHelper.hasObject(str, ListAdapter.this.tableName)) {
                        favImg.setImageResource(R.drawable.ic_favyes_white);
                        favTv.setText("Remove From Fav");
                    } else {
                        favImg.setImageResource(R.drawable.ic_favno_white);
                        favTv.setText("Add To Fav");
                    }
                    mBottomSheetDialog.show();
                }
            });
            paramView.setTag(holder);

        } else {
            holder = (ViewHolder) paramView.getTag();
        }




        Model currentItem = (Model) getItem(paramInt);
        //TextView textViewItemName = (TextView) paramView.findViewById(R.id.ss);
        // textViewItemName.setText(currentItem.getDuration());
        //String s = modellist.get(paramInt).getTitle();
        //Toast.makeText(mContext, "model data " + s, Toast.LENGTH_SHORT).show();












        holder.mTitleTv.setText(currentItem.getTitle());
        holder.mDurationTv.setText(currentItem.getDuration());
        holder.mVolumeTv.setText(currentItem.getVolume());
        holder.mActivationTv.setText(currentItem.getActivation());
        holder.mDeactivationTv.setText(currentItem.getDeactivation());
        holder.mRemainingTv.setText(currentItem.getRemaining());
        holder.mInfoTv.setText(currentItem.getInfo());
        holder.mPriceTv.setText(currentItem.getPrice());
        return paramView;
    }


    //check fav
    private void checkFav(ViewHolder paramViewHolder) {
        String str2 = paramViewHolder.mTitleTv.getText().toString();
        String str3 = paramViewHolder.mDurationTv.getText().toString();
        String str4 = paramViewHolder.mVolumeTv.getText().toString();
        String str5 = paramViewHolder.mActivationTv.getText().toString();
        String str6 = paramViewHolder.mDeactivationTv.getText().toString();
        String str7 = paramViewHolder.mRemainingTv.getText().toString();
        String str8 = paramViewHolder.mInfoTv.getText().toString();
        String str1 = paramViewHolder.mPriceTv.getText().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        stringBuilder.append(str4);
        stringBuilder.append(str5);
        stringBuilder.append(str6);
        stringBuilder.append(str7);
        stringBuilder.append(str8);
        stringBuilder.append(str1);
        stringBuilder.toString();
        if (this.mSQLiteHelper.hasObject(str2, this.tableName)) {
            this.mSQLiteHelper.deleteData(this.tableName, str2);
            Toast.makeText(this.mContext, "Removed from My Packages", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            this.mSQLiteHelper.insertData(this.tableName, str2, str3, str4, str5, str6, str7, str1);
            Toast.makeText(this.mContext, "Added to My Packages", Toast.LENGTH_SHORT).show();
            return;
        } catch (Exception sstr1) {
            Context context = this.mContext;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("");
            stringBuilder1.append(sstr1.getMessage());
            Toast.makeText(context, stringBuilder1.toString(), Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //copy data
    private void copyData(ViewHolder paramViewHolder) {
        String str2 = paramViewHolder.mTitleTv.getText().toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("\nDuration: ");
        stringBuilder1.append(paramViewHolder.mDurationTv.getText().toString());
        String str3 = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\nVolume: ");
        stringBuilder2.append(paramViewHolder.mVolumeTv.getText().toString());
        String str4 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("\nActivation: ");
        stringBuilder3.append(paramViewHolder.mActivationTv.getText().toString());
        String str5 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("\nDeactivation: ");
        stringBuilder4.append(paramViewHolder.mDeactivationTv.getText().toString());
        String str6 = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("\nRemaining: ");
        stringBuilder5.append(paramViewHolder.mRemainingTv.getText().toString());
        String str7 = stringBuilder5.toString();
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append("\nInfo: ");
        stringBuilder6.append(paramViewHolder.mInfoTv.getText().toString());
        String str8 = stringBuilder6.toString();
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append("\nPrice: ");
        stringBuilder7.append(paramViewHolder.mPriceTv.getText().toString());
        String str1 = stringBuilder7.toString();
        stringBuilder7 = new StringBuilder();
        stringBuilder7.append(str2);
        stringBuilder7.append(str3);
        stringBuilder7.append(str4);
        stringBuilder7.append(str5);
        stringBuilder7.append(str6);
        stringBuilder7.append(str7);
        stringBuilder7.append(str8);
        stringBuilder7.append(str1);
        str1 = stringBuilder7.toString();
        Utils.copyText(this.mContext, str1);
    }

    //share data
    private void shareData(ViewHolder paramViewHolder) {
        String str2 = paramViewHolder.mTitleTv.getText().toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("\nDuration: ");
        stringBuilder1.append(paramViewHolder.mDurationTv.getText().toString());
        String str3 = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\nVolume: ");
        stringBuilder2.append(paramViewHolder.mVolumeTv.getText().toString());
        String str4 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("\nActivation: ");
        stringBuilder3.append(paramViewHolder.mActivationTv.getText().toString());
        String str5 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("\nDeactivation: ");
        stringBuilder4.append(paramViewHolder.mDeactivationTv.getText().toString());
        String str6 = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("\nRemaining: ");
        stringBuilder5.append(paramViewHolder.mRemainingTv.getText().toString());
        String str7 = stringBuilder5.toString();
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append("\nInfo: ");
        stringBuilder6.append(paramViewHolder.mInfoTv.getText().toString());
        String str8 = stringBuilder6.toString();
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append("\nPrice: ");
        stringBuilder7.append(paramViewHolder.mPriceTv.getText().toString());
        String str1 = stringBuilder7.toString();
        stringBuilder7 = new StringBuilder();
        stringBuilder7.append(str2);
        stringBuilder7.append(str3);
        stringBuilder7.append(str4);
        stringBuilder7.append(str5);
        stringBuilder7.append(str6);
        stringBuilder7.append(str7);
        stringBuilder7.append(str8);
        stringBuilder7.append(str1);
        str1 = stringBuilder7.toString();
        Utils.shareText(this.mContext, str1);
    }




    //filter
    public void filter(String paramString) {
        paramString = paramString.toLowerCase(Locale.getDefault());
        this.modellist.clear();
        if (paramString.length() == 0) {
            this.modellist.addAll(this.arrayList);
        } else {
            for (Model model : this.arrayList) {
                if (model.getTitle().toLowerCase(Locale.getDefault()).contains(paramString) || model.getPrice().toLowerCase(Locale.getDefault()).contains(paramString) || model.getActivation().toLowerCase(Locale.getDefault()).contains(paramString))
                    this.modellist.add(model);
            }
        }
        notifyDataSetChanged();
    }


    //hold views
    public class ViewHolder {

        TextView mActivationTv;



        TextView mDeactivationTv;

        TextView mDurationTv;

        TextView mInfoTv;

        TextView mPriceTv;



        TextView mRemainingTv;



        TextView mVolumeTv;
        Button mActivateBtn;
        Button mBtnMore;
        TextView mTitleTv, maa;

        Button mDeactivateBtn;
        Button mRemainingBtn;

        public ViewHolder(View paramView) {
            mActivateBtn = (Button) paramView.findViewById(R.id.activateBtn);
            mDeactivateBtn = (Button) paramView.findViewById(R.id.deactivateBtn);
            mRemainingBtn = (Button) paramView.findViewById(R.id.remainingBtn);
            mBtnMore = (Button) paramView.findViewById(R.id.moreBtn);
            mTitleTv = (TextView) paramView.findViewById(R.id.titleTv);
            mDurationTv = (TextView) paramView.findViewById(R.id.durationTv);
            mVolumeTv = (TextView) paramView.findViewById(R.id.volumeTv);
            mActivationTv = (TextView) paramView.findViewById(R.id.activationTv);
            mDeactivationTv = (TextView) paramView.findViewById(R.id.deactivationTv);
            mRemainingTv = (TextView) paramView.findViewById(R.id.remainingTv);
            mInfoTv = (TextView) paramView.findViewById(R.id.infoTv);
            mPriceTv = (TextView) paramView.findViewById(R.id.priceTv);
        }

    }

}
