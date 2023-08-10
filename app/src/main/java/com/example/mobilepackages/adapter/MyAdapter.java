package com.example.mobilepackages.adapter;

public class MyAdapter {}
  /*  private Context context;

    private int layout;

    private ArrayList<MyModel> recordList;

    public MyAdapter(Context paramContext, int paramInt, ArrayList<MyModel> paramArrayList) { this.context = paramContext;
        this.layout = paramInt;
        this.recordList = paramArrayList; }

    public int getCount() { return this.recordList.size(); }

    public Object getItem(int paramInt) { return this.recordList.get(paramInt); }

    public long getItemId(int paramInt) { return paramInt; }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        final ViewHolder finalHolder = new ViewHolder(null);
        if (paramView == null) {
            paramView = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(this.layout, null);
            viewHolder.idTv = (TextView)paramView.findViewById(2131296391);
            viewHolder.titleTv = (TextView)paramView.findViewById(2131296515);
            viewHolder.durationTv = (TextView)paramView.findViewById(2131296362);
            viewHolder.volumeTv = (TextView)paramView.findViewById(2131296535);
            viewHolder.activationTv = (TextView)paramView.findViewById(2131296309);
            viewHolder.deactivationTv = (TextView)paramView.findViewById(2131296351);
            viewHolder.remainingTv = (TextView)paramView.findViewById(2131296446);
            viewHolder.priceTv = (TextView)paramView.findViewById(2131296437);
            viewHolder.infoTv = (TextView)paramView.findViewById(2131296396);
            viewHolder.activateBtn = (Button)paramView.findViewById(2131296307);
            viewHolder.deactivateBtn = (Button)paramView.findViewById(2131296349);
            viewHolder.remainingBtn = (Button)paramView.findViewById(2131296444);
            viewHolder.moreBtn = (Button)paramView.findViewById(2131296417);
            final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this.context);
            View view = LayoutInflater.from(this.context).inflate(2131492903, null);
            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.setTitle("Choose");
            CardView cardView1 = (CardView)view.findViewById(2131296344);
            CardView cardView2 = (CardView)view.findViewById(2131296472);
            CardView cardView3 = (CardView)view.findViewById(2131296364);
            CardView cardView4 = (CardView)view.findViewById(2131296354);
            cardView1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) { mBottomSheetDialog.dismiss();
                    this.val$finalHolder.idTv.getText().toString();
                    String str1 = this.val$finalHolder.titleTv.getText().toString();
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("\nDuration: ");
                    stringBuilder1.append(this.val$finalHolder.durationTv.getText().toString());
                    String str2 = stringBuilder1.toString();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("\nVolume: ");
                    stringBuilder2.append(this.val$finalHolder.volumeTv.getText().toString());
                    String str3 = stringBuilder2.toString();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("\nActivation: ");
                    stringBuilder3.append(this.val$finalHolder.activationTv.getText().toString());
                    String str4 = stringBuilder3.toString();
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("\nDeactivation: ");
                    stringBuilder4.append(this.val$finalHolder.deactivationTv.getText().toString());
                    String str5 = stringBuilder4.toString();
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("\nRemaining: ");
                    stringBuilder5.append(this.val$finalHolder.remainingTv.getText().toString());
                    String str6 = stringBuilder5.toString();
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append("\nPrice: ");
                    stringBuilder6.append(this.val$finalHolder.priceTv.getText().toString());
                    String str7 = stringBuilder6.toString();
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append(str1);
                    stringBuilder7.append(str2);
                    stringBuilder7.append(str3);
                    stringBuilder7.append(str4);
                    stringBuilder7.append(str5);
                    stringBuilder7.append(str6);
                    stringBuilder7.append(str7);
                    str1 = stringBuilder7.toString();
                    Utils.copyText(MyAdapter.access$100(MyAdapter.this), str1); }
            });
            cardView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) { mBottomSheetDialog.dismiss();
                    this.val$finalHolder.idTv.getText().toString();
                    String str1 = this.val$finalHolder.titleTv.getText().toString();
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("\nDuration: ");
                    stringBuilder1.append(this.val$finalHolder.durationTv.getText().toString());
                    String str2 = stringBuilder1.toString();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("\nVolume: ");
                    stringBuilder2.append(this.val$finalHolder.volumeTv.getText().toString());
                    String str3 = stringBuilder2.toString();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("\nActivation: ");
                    stringBuilder3.append(this.val$finalHolder.activationTv.getText().toString());
                    String str4 = stringBuilder3.toString();
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("\nDeactivation: ");
                    stringBuilder4.append(this.val$finalHolder.deactivationTv.getText().toString());
                    String str5 = stringBuilder4.toString();
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("\nRemaining: ");
                    stringBuilder5.append(this.val$finalHolder.remainingTv.getText().toString());
                    String str6 = stringBuilder5.toString();
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append("\nPrice: ");
                    stringBuilder6.append(this.val$finalHolder.priceTv.getText().toString());
                    String str7 = stringBuilder6.toString();
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append(str1);
                    stringBuilder7.append(str2);
                    stringBuilder7.append(str3);
                    stringBuilder7.append(str4);
                    stringBuilder7.append(str5);
                    stringBuilder7.append(str6);
                    stringBuilder7.append(str7);
                    str1 = stringBuilder7.toString();
                    Utils.shareText(MyAdapter.access$100(MyAdapter.this), str1); }
            });
            cardView3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) { mBottomSheetDialog.dismiss();
                    String str1 = this.val$finalHolder.idTv.getText().toString();
                    String str2 = this.val$finalHolder.titleTv.getText().toString();
                    String str3 = this.val$finalHolder.durationTv.getText().toString();
                    String str4 = this.val$finalHolder.volumeTv.getText().toString();
                    String str5 = this.val$finalHolder.activationTv.getText().toString();
                    String str6 = this.val$finalHolder.deactivationTv.getText().toString();
                    String str7 = this.val$finalHolder.remainingTv.getText().toString();
                    String str8 = this.val$finalHolder.priceTv.getText().toString();
                    String str9 = MyAdapter.access$100(MyAdapter.this).getSharedPreferences("MyAdded", 0).getString("tableName", "JazzWarid");
                    Intent intent = new Intent(MyAdapter.access$100(MyAdapter.this), com.blogspot.atifsoftwares.mobilepackagespakistan.activities.MyAddActivity.class);
                    intent.putExtra("tableName", str9);
                    intent.putExtra("id", str1);
                    intent.putExtra("title", str2);
                    intent.putExtra("duration", str3);
                    intent.putExtra("volume", str4);
                    intent.putExtra("activation", str5);
                    intent.putExtra("deactivation", str6);
                    intent.putExtra("remaining", str7);
                    intent.putExtra("price", str8);
                    MyAdapter.access$100(MyAdapter.this).startActivity(intent); }
            });
            cardView4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) { mBottomSheetDialog.dismiss();
                    str1 = this.val$finalHolder.idTv.getText().toString();
                    String str2 = MyAdapter.access$100(MyAdapter.this).getSharedPreferences("MyAdded", 0).getString("tableName", "JazzWarid");
                    try {
                        (new MyDbHelper(MyAdapter.access$100(MyAdapter.this), "RECORDDB.sqlite", null, true)).deleteData(str2, Integer.parseInt(str1));
                        Toast.makeText(MyAdapter.access$100(MyAdapter.this), "Deleted successfully...\nChanges will apply after restarting app", 1).show();
                        return;
                    } catch (Exception str1) {
                        Context context = MyAdapter.access$100(MyAdapter.this);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("");
                        stringBuilder.append(str1.getMessage());
                        Toast.makeText(context, stringBuilder.toString(), 0).show();
                        return;
                    }  }
            });
            viewHolder.activateBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    String str = this.val$finalHolder.activationTv.getText().toString();
                    if (str.equals("N/A")) {
                        Toast.makeText(MyAdapter.access$100(MyAdapter.this), "N/A", 0).show();
                        return;
                    }
                    if (str.contains("Send")) {
                        Toast.makeText(MyAdapter.access$100(MyAdapter.this), str, 0).show();
                        return;
                    }
                    if (str.contains("*6464")) {
                        Utils.dial(MyAdapter.access$100(MyAdapter.this), "*6464#");
                        return;
                    }
                    Utils.dial(MyAdapter.access$100(MyAdapter.this), str);
                }
            });
            viewHolder.deactivateBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    String str = this.val$finalHolder.deactivationTv.getText().toString();
                    if (str.equals("N/A")) {
                        Toast.makeText(MyAdapter.access$100(MyAdapter.this), "N/A", 0).show();
                        return;
                    }
                    if (str.contains("Send")) {
                        Toast.makeText(MyAdapter.access$100(MyAdapter.this), str, 0).show();
                        return;
                    }
                    if (str.contains("*6464")) {
                        Utils.dial(MyAdapter.access$100(MyAdapter.this), "*6464#");
                        return;
                    }
                    Utils.dial(MyAdapter.access$100(MyAdapter.this), str);
                }
            });
            viewHolder.remainingBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    String str = this.val$finalHolder.remainingTv.getText().toString();
                    if (str.equals("N/A")) {
                        Toast.makeText(MyAdapter.access$100(MyAdapter.this), "N/A", 0).show();
                        return;
                    }
                    if (str.contains("Send")) {
                        Toast.makeText(MyAdapter.access$100(MyAdapter.this), str, 0).show();
                        return;
                    }
                    if (str.contains("*6464")) {
                        Utils.dial(MyAdapter.access$100(MyAdapter.this), "*6464#");
                        return;
                    }
                    Utils.dial(MyAdapter.access$100(MyAdapter.this), str);
                }
            });
            viewHolder.moreBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) { this.val$finalHolder.titleTv.getText().toString();
                    mBottomSheetDialog.show(); }
            });
            paramView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)paramView.getTag();
        }
        MyModel myModel = (MyModel)this.recordList.get(paramInt);
        TextView textView = viewHolder.idTv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(myModel.getId());
        textView.setText(stringBuilder.toString());
        viewHolder.titleTv.setText(myModel.getTitle());
        viewHolder.durationTv.setText(myModel.getDuration());
        viewHolder.volumeTv.setText(myModel.getVolume());
        viewHolder.activationTv.setText(myModel.getActivation());
        viewHolder.deactivationTv.setText(myModel.getDeactivation());
        viewHolder.remainingTv.setText(myModel.getRemaining());
        viewHolder.priceTv.setText(myModel.getPrice());
        viewHolder.infoTv.setVisibility(8);
        return paramView;
    }

    private class ViewHolder {
        Button activateBtn;

        TextView activationTv;

        Button deactivateBtn;

        TextView deactivationTv;

        TextView durationTv;

        TextView idTv;

        TextView infoTv;

        Button moreBtn;

        TextView priceTv;

        Button remainingBtn;

        TextView remainingTv;

        TextView titleTv;

        TextView volumeTv;

        private ViewHolder() {}
    }
*/