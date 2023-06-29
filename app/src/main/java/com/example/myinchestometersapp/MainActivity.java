package com.example.myinchestometersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInches;
    private TextView textViewMeters;
    private Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        buttonClicked();

    }

    private void buttonClicked() {
        buttonConvert.setOnClickListener(c->{
            if(editTextInches.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Please Enter a value to convert",Toast.LENGTH_LONG).show();
            }else {
                double meters = convertToMeters();
                displayResult(meters);
            }
        });
    }

    private void findViews() {
        buttonConvert = findViewById(R.id.button_convert);
        editTextInches = findViewById(R.id.editText_inches);
        textViewMeters = findViewById(R.id.textView_meters);
    }

    private double convertToMeters() {
        String inchesText = editTextInches.getText().toString();
        double inches = Double.parseDouble(inchesText);
        return inches * 0.0254;
    }

    private void displayResult(double meters) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String displayResult = decimalFormat.format(meters);
        textViewMeters.setText(displayResult);
    }


}