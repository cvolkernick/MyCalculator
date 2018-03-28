package com.example.admin.mycalculator;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String currentValue = "";
    private String resultValue = "";
    private TextView inputDisplay;
    private TextView resultDisplay;
    private String currentOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onDelete(View view) {
        Log.d("Buttons", "delete");

        inputDisplay = findViewById(R.id.tvInputDisplay);

        if (inputDisplay.getText().length() > 1) {
            currentValue = currentValue.substring(0, currentValue.length()-1);
        }
        else {
            currentValue = "";
        }

        inputDisplay.setText(currentValue);
    }

    public void onClear(View view) {
        Log.d("Buttons","clear");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        resultDisplay = findViewById(R.id.tvResultDisplay);
        currentValue = "";
        resultValue = "";
        inputDisplay.setText(currentValue);
        resultDisplay.setText(resultValue);
    }

    public void onPercent(View view) {
        Log.d("Buttons","percent");
    }

    public void onDivide(View view) {
        Log.d("Buttons","divide");
    }

    public void onSeven(View view) {
        Log.d("Buttons","seven");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "7";
        inputDisplay.setText(currentValue);
    }

    public void onEight(View view) {
        Log.d("Buttons","eight");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "8";
        inputDisplay.setText(currentValue);
    }

    public void onNine(View view) {
        Log.d("Buttons","nine");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "9";
        inputDisplay.setText(currentValue);
    }

    public void onMultiply(View view) {
        Log.d("Buttons","multiply");
    }

    public void onFour(View view) {
        Log.d("Buttons","four");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "4";
        inputDisplay.setText(currentValue);
    }

    public void onFive(View view) {
        Log.d("Buttons","five");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "5";
        inputDisplay.setText(currentValue);
    }

    public void onSix(View view) {
        Log.d("Buttons","six");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "6";
        inputDisplay.setText(currentValue);
    }

    public void onMinus(View view) {
        Log.d("Buttons","minus");
    }

    public void onOne(View view) {
        Log.d("Buttons","one");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "1";
        inputDisplay.setText(currentValue);
    }

    public void onTwo(View view) {
        Log.d("Buttons","two");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "2";
        inputDisplay.setText(currentValue);
    }

    public void onThree(View view) {
        Log.d("Buttons","three");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        currentValue += "3";
        inputDisplay.setText(currentValue);
    }

    public void onPlus(View view) {
        Log.d("Buttons","plus");

        inputDisplay = findViewById(R.id.tvInputDisplay);
        resultDisplay = findViewById(R.id.tvResultDisplay);

        if (currentValue != "" & resultValue != "") {
            switch (currentOperation) {
                case "add":
                    double result = Math.add(Double.parseDouble(currentValue), Double.parseDouble(resultValue));

                    if (Math.isWhole(result)) {
                        resultValue = (int)result + "";
                    }
                    else {
                        resultValue = result + "";
                    }

                    currentValue = "";
                    currentOperation = "add";
            }
        }
        else {
            resultValue = currentValue;
            currentValue = "";
            currentOperation = "add";
        }

        inputDisplay.setText(currentValue);
        resultDisplay.setText(resultValue);
    }

    public void onNegPos(View view) {
        Log.d("Buttons","negpos");
    }

    public void onZero(View view) {
        Log.d("Buttons","zero");

        inputDisplay = findViewById(R.id.tvInputDisplay);

        if (currentValue != "") {
            currentValue += "0";
            inputDisplay.setText(currentValue);
        }
    }

    public void onDecimal(View view) {
        Log.d("Buttons","decimal");

        inputDisplay = findViewById(R.id.tvInputDisplay);

        if (!currentValue.contains(".")) {
            currentValue += ".";
        }

        inputDisplay.setText(currentValue);
    }

    public void onEquals(View view) {
        Log.d("Buttons","equals");

        if (resultValue != "" & currentValue != "") {
            switch (currentOperation) {
                case "add":
                    double result = Math.add(Double.parseDouble(resultValue), Double.parseDouble(currentValue));
                    currentValue = "";
                    currentOperation = "";

                    if (Math.isWhole(result)) {
                        resultValue = (int)result + "";
                    }
                    else {
                        resultValue = result + "";
                    }

                    resultDisplay.setText(resultValue);
                    inputDisplay.setText(currentValue);
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_LONG).show();


        }
    }
}