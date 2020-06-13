package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText TextBox = (EditText) findViewById(R.id.text_box);
        String text = TextBox.getText().toString();
        boolean whipp=WhippedCreamCheckBox.isChecked();
        boolean choc = ChocolateCheckBox.isChecked();
        int whip_price = 0, choc_price = 0;
        if(whipp)
            whip_price = 1;
        if (choc)
            choc_price = 2;
        String pricecMessage = "Name: " + text + "\nAdd Whipped Cream? " + whipp + "\nAdd Chocolate? " + choc;
        pricecMessage += "\nQuantity: " + quantity + "\nTotal: $" + (int) (quantity * 2 + whip_price + choc_price) + "\nThank You!";
       displayMessage(pricecMessage);
    }
    int quantity=2;
    public void increment(View view){
         quantity++;
        if (quantity > 100)
            return;
        display(quantity);
    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void decrement(View view)
    {
        quantity--;
        if (quantity < 1)
            return;
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
