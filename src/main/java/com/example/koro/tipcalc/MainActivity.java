package com.example.koro.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tipTotalTextView;
    TextView totalAmountTextView;
    EditText billTotalEditText;
    EditText tipEditText;
    Button tenButton;
    Button fifteenButton;
    Button twentyButton;
    Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipTotalTextView = (TextView) findViewById(R.id.tipTotalTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);
        billTotalEditText = (EditText) findViewById(R.id.billTotalEditText);
        tipEditText = (EditText) findViewById(R.id.tipEditText);
        tenButton = (Button) findViewById(R.id.tenButton);
        fifteenButton = (Button) findViewById(R.id.fifteenButton);
        twentyButton = (Button) findViewById(R.id.twentyButton);
        calcButton = (Button) findViewById(R.id.calcButton);

        tenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTip(0.1);
            }
        });

        fifteenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTip(0.15);
            }
        });

        twentyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTip(0.2);
            }
        });

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTip(Double.valueOf(tipEditText.getText().toString()) / 100);
            }
        });


    }

    void calcTip(Double tipPercentage) {

        // 1. Get the bill from the Edit Text.
        Double bill = Double.valueOf(billTotalEditText.getText().toString());

        // 2. Determine the tip and display it.
        Double tip = tipPercentage * bill;
        tipTotalTextView.setText("Tip - " + String.format("%.2f", tip) + " GBP");

        // 3. Determine the total and display it.
        Double total = bill + tip;
        totalAmountTextView.setText("Total - " + String.format("%.2f", total) + " GBP");
    }
}
