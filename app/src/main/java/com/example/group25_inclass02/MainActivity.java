/*
Assignment #: InClass02
File Name: Group25_InClass02 MainActivity.java
Name: Kristin Pflug
 */

package com.example.group25_inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ticketPriceEditText;
    TextView discountPriceTextView;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticketPriceEditText = findViewById(R.id.ticket_price_input);
        discountPriceTextView = findViewById(R.id.result_text);
        radioGroup = findViewById(R.id.radioGroup);

        findViewById(R.id.calculate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    double ticketPrice = Double.parseDouble(ticketPriceEditText.getText().toString());
                    int checkedID = radioGroup.getCheckedRadioButtonId();
                    int discount = 0;

                    if(checkedID != -1) {
                        if (checkedID == R.id.five_percent_radio) {
                            discount = 5;
                        } else if (checkedID == R.id.ten_percent_radio) {
                            discount = 10;
                        } else if (checkedID == R.id.fifteen_percent_radio) {
                            discount = 15;
                        } else if (checkedID == R.id.twenty_percent_radio) {
                            discount = 20;
                        } else if (checkedID == R.id.fifty_percent_radio) {
                            discount = 50;
                        }

                        double s = 100 - discount;
                        double amount = (s*ticketPrice)/100;
                        discountPriceTextView.setText("" + String.format("%.2f", amount));
                    } else {
                        Toast.makeText(MainActivity.this,getString(R.string.noDiscountSelected), Toast.LENGTH_SHORT).show();
                    }


                } catch (NumberFormatException nfe) {
                    //print Toast message
                    Toast.makeText(MainActivity.this,getString(R.string.nfeErrorText), Toast.LENGTH_SHORT).show();
                }

            }
        });

        findViewById(R.id.clear_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ticketPriceEditText.setText("");
                radioGroup.clearCheck();
                discountPriceTextView.setText("");
            }

        });
    }
}