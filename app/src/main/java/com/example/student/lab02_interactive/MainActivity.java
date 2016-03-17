package com.example.student.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //m: Member (Data Member 資料成員)
    private int mquantity = 0;
    private int mprice = 50;
    //private final  String mNT$ = "NT$";
    private String mName = "鳴人";
    private StringBuilder mTotalPriceMessage = new StringBuilder("NT$" + mprice);
    private StringBuilder  mQuantityMessage = new StringBuilder(mquantity);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display();//程式初始顯示
    }
        //order Button
    public void submitOrder(View view) {
        clearPriceMessage();//刪除 mPriceMessage
        concatPriceMessage();//組合 人名 + 臭豆腐 + 是否家泡菜 + Free 或 NT$
        display();//dispalay
    }


    private void displayer() {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
       // quantity.setText(String.valueOf(mquantity));
        int start = 0;
        int end = mQuantityMessage.length();
        mQuantityMessage.delete(start, end).append(mquantity);
        quantity.setText(mQuantityMessage);
    }
    private void clearPriceMessage(){
        int start = 0;
        int end = mTotalPriceMessage.length();
        mTotalPriceMessage.delete(start, end);
    }
    private void display(){
        TextView priceTextView = (TextView) findViewById(R.id.pirce_text_view);
        priceTextView.setText(mTotalPriceMessage);
      //  int total = mprice * mquantity;
       // int startIndex = mNT$.length();
       // int endIndex = mTotalPriceMessage.length();
       // mTotalPriceMessage.delete(startIndex, endIndex).append(total)
            //    .append(mquantity == 0 ? "\nFree!!" : "\nThankyou!!");

      //  String myString = NumberFormat.getCurrencyInstance().format(total);
       // StringBuilder優化display()
       // String message = myString + (mquantity == 0? "\nFree!!" : "\nThankyou!!");
       // priceTextView.setText(message);


      //  if(mquantity > 0){
         //  priceTextView.setText(String.valueOf(mquantity));
          //  String myStringto = NumberFormat.getCurrencyInstance().format(total);
         //   priceTextView.setText("Name" + mName + "\n臭豆腐" + "\n加泡菜?" + "\n數量:" +
           //         mquantity + "\n" + myStringto + "\nThankyou!!");
        //}
      //  else if(mquantity == 0){
       //     priceTextView.setText(String.valueOf(mquantity));
          //  String myStringto = NumberFormat.getCurrencyInstance().format(total);
          //  priceTextView.setText("Name" + mName + "\n臭豆腐" + "\n加泡菜?"  + "\n數量" +
           //         mquantity + "\n" +myStringto + "\nFree!!");
       // }
    }


    public void concatPriceMessage() {
        final CheckBox checkbox = (CheckBox) findViewById(R.id.topping_checkbox);
        mTotalPriceMessage.append("Name:").append(mName)
                .append("\n")
                .append("加泡菜?").
                append(checkbox.isChecked())
                .append("\n");
        if(mquantity == 0 ){
            mTotalPriceMessage.append("Free");
        }
        else{
            mTotalPriceMessage.append("數量")
                    .append(mquantity)
                    .append("\n")
                    .append("總價")
                    .append("NT$")
                    .append(mprice * mquantity)
                    .append("\n")
                    .append("Thanktou!")
                    .append("\n");

        }
    }

   public void check(View view){
        resettotalPrice();
        display();
   }

    public void add(View view){
           // 從TextView 取得數量，數量加 1 並顯示
          ++mquantity;
            displayer();
        resettotalPrice();
        }
    public void back(View view){
        // 從TextView 取得數量，數量加 1 並顯示

        if(mquantity > 0) {
            --mquantity;
            displayer();
            resettotalPrice();
        }
    }
    public void resettotalPrice(){
        //刪除 mPriceMessage
        clearPriceMessage();
        //新增新的 mTotalPrcieMessage
        mTotalPriceMessage.append("臭豆腐")
                .append("NT$")
                .append(mprice);
       // TextView priceTextView = (TextView) findViewById(R.id.pirce_text_view);
      //  priceTextView.setText("");
    }
    //private int getQuantity() {
      //  TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
       // 將文字轉成整數
      //  String quantityString = quantityTextView.getText().toString();

       // return Integer.parseInt(quantityString);
  //  }




  //  public void a(int nuber){
     //   TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
      //  quantityTextView.setText(String.valueOf(nuber));
   // }


   // public void add(View view) {
    //    a(++mquantity);

  // }

   // public void back(View view) {
   // if(mquantity > 0){
   // a(--mquantity);
   // }
  //  }


}
