package com.zybooks.tipcalculator;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText EnterAmount;
    private SeekBar seekBar;
    private TextView TipPercent;
    private Button Activate;
    private TextView TipAmount;
    private TextView TotalAmount;

    private int seekbarpercentage;
    private float enterbillfloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnterAmount = (EditText) findViewById(R.id.EnterAmount);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        TipPercent = (TextView) findViewById(R.id.TipPercent);
        Activate = (Button) findViewById(R.id.Activate);
        TipAmount = (TextView) findViewById(R.id.TipAmount);
        TotalAmount = (TextView) findViewById(R.id.TotalAmount);
        //----------------------------
        TipPercent.setText("YOU SELECT " + seekBar.getProgress() + "%");
        //-----------------------------
        Activate.setOnClickListener(this);
        //-----------------------------
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TipPercent.setText("%" + String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarpercentage = seekBar.getProgress();
                //Toast.makeText(getApplicationContext(), "STOP", Toast.LENGTH_LONG).show();
            }
        });
    }

    //-----------------------------
    @Override
    public void onClick(View view) {
        calculate();
    }

    public void calculate() {
        float result = 0.0f;
        if (!EnterAmount.getText().toString().equals("")) {

            enterbillfloat = Float.parseFloat(EnterAmount.getText().toString());
            result=(enterbillfloat*seekbarpercentage/100);
            TipAmount.setText("$" + String.valueOf(result));

            TotalAmount.setText("$"+ String.valueOf(enterbillfloat + result));

        } else {
            Toast.makeText(getApplicationContext(), "ERROR PLEASE ENTER AMOUNT", Toast.LENGTH_LONG).show();
        }

    }
}