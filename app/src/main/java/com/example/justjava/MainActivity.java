package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitOrder(View view) {
        CheckBox WhippedCreamCheckBox=(CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean whipp=WhippedCreamCheckBox.isChecked();
        int whip_price=0;
        if(whipp)
            whip_price=5;
       String pricecMessage="Name: Sanskriti Chauhan"+"\nAdd Whipped Cream? "+whipp;
       pricecMessage+="\nQuantity: "+quantity+"\nTotal: $"+(int)(quantity*2+whip_price)+"\nThank You!";
       displayMessage(pricecMessage);
    }
    int quantity=2;
    public void increment(View view){
         quantity++;
        display(quantity);
    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void decrement(View view)
    {
        quantity--;
        display(quantity);
    }
    /**
     * This method displays the given price on the screen.
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }
}
