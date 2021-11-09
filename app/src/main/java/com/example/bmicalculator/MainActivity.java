package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight, height;
    TextView result;
    Button btnCalculate;
    String calculation, BMIres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String s1 = weight.getText().toString();
        String s2 = height.getText().toString();

        float weightValue = Float.parseFloat(s1);
        float heightValue = Float.parseFloat(s2) / 100;

        float bmi = weightValue / (heightValue * heightValue);

        displayBMI(bmi);
    }

    private void displayBMI(float bmi){
        if(bmi < 16){
            BMIres = "Severely under wight";
        }else if (bmi < 18.5){
            BMIres = "Under weight";
        }else if (bmi >= 18.5 && bmi <= 24.9){
            BMIres = "Normal weight";
        }else if (bmi >= 25 && bmi <=29.9){
            BMIres = "Overweight";
        }else {
            BMIres = "Obese";
        }

        calculation = "Result: " + bmi + "\n" + BMIres;
        result.setText(calculation);
    }
}