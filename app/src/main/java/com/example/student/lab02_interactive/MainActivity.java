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
    diplay(i);
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

    int i =0;

    public void add(View view) {
        a(++i);
    }

    public void back(View view) {
        a(--i);
    }

    public void a(int nuber){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(nuber));
    }
}
