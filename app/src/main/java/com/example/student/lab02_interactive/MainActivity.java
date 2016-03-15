package com.example.student.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    //m: Member (Data Member 資料成員)
    private int mquantity = 0;
    private int mprice = 20;
    private final  String mNT$ = "NT$";
    private  StringBuilder mTotalPriceMessage = new StringBuilder(mNT$);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

    display();
    }

    private void displayer() {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText(String.valueOf(mquantity));
    }
    private void display(){
        TextView priceTextView = (TextView) findViewById(R.id.pirce_text_view);
        int total = mprice * mquantity;
        int startIndex = mNT$.length();
        int endIndex = mTotalPriceMessage.length();
        mTotalPriceMessage.delete(startIndex,endIndex).append(total)
                .append(mquantity == 0? "\nFree!!" : "\nThankyou!!");
       //String myString = NumberFormat.getCurrencyInstance().format(total);
        //StringBuilder優化display()
        //String message = myString + (mquantity == 0? "\nFree!!" : "\nThankyou!!");
        //priceTextView.setText(message);
        priceTextView.setText(mTotalPriceMessage);

        if(mquantity > 0){
            priceTextView.setText(String.valueOf(mquantity));
            String myStringto = NumberFormat.getCurrencyInstance().format(total);
            priceTextView.setText(myStringto + "\nThankyou!!");
        }
        else if(mquantity == 0){
            priceTextView.setText(String.valueOf(mquantity));
            String myStringto = NumberFormat.getCurrencyInstance().format(total);
            priceTextView.setText(myStringto + "\nFree!!");
        }

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
        TextView priceTextView = (TextView) findViewById(R.id.pirce_text_view);
        priceTextView.setText("");
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
