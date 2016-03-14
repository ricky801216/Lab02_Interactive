package com.example.student.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
    diplay(0);
    }

    private void diplay(int number) {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText(String.valueOf(number));
        TextView priceTextView = (TextView) findViewById(R.id.pirce_text_view);
        int price = 10;//價錢
        int total = price * number;
        String myString = NumberFormat.getCurrencyInstance().format(total);
        priceTextView.setText(myString);
    }

        public void add(View view){
            //從TextView 取得數量，數量加 1 並顯示
            int quantity = getQuantity();
            diplay(++quantity);
        }

    private int getQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        //將文字轉成整數
        String quantityString = quantityTextView.getText().toString();
        return Integer.parseInt(quantityString);
    }

    public void back(View view){
        //從TextView 取得數量，數量加 1 並顯示
        int quantity = getQuantity();
            if(quantity > 0) {
                diplay(--quantity);
            }
    }
    //public void a(int nuber){
       // TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        //quantityTextView.setText(String.valueOf(nuber));
    //}
    //int i =0;

  //  public void add(View view) {
    //    a(++i);
   // }

   // public void back(View view) {
   // if(i > 0){
   // a(--i);}
   // }


}
