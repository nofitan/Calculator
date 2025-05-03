package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView result;
    String operation = " ";
    double num,num1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById(R.id.textView2);
        result.setText("");
        num = 0;
        num1 = 0;
    }

    public void numFunc(View view) {
        Button button = (Button) view;

        result.append(button.getText().toString());
    }

    public void charOp(View view) {
        Button button = (Button) view;
        String op = button.getText().toString();

        if (!result.getText().toString().isEmpty()) {
            num = Double.parseDouble(result.getText().toString());
            operation = op;
            result.setText("");
        }
    }


    public void equals(View view) {
        if (!result.getText().toString().isEmpty() && !operation.isEmpty()) {
            num1 = Double.parseDouble(result.getText().toString());
            double res = 0;

            switch (operation) {
                case "+":
                    res = num + num1;
                    break;
                case "-":
                    res = num - num1;
                    break;
                case "X":
                    res = num * num1;
                    break;
                case "/":
                    if (num1 != 0) {
                        res = num / num1;
                    } else {
                        result.setText("Error");
                        return;
                    }
                    break;
            }

            result.setText(String.valueOf(res));
            num = res;
            operation = "";
        }
    }


    public void clear(View view) {
        result.setText("");
        num = 0;
        num1 = 0;
        operation = "";
    }
}