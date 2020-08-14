package com.example.ex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    CheckBox chk1, chk2, chk3, chk4, chk5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview1);
        chk1 = findViewById(R.id.checkbox1);
        chk2 = findViewById(R.id.checkbox2);
        chk3 = findViewById(R.id.checkbox3);
        chk4 = findViewById(R.id.checkbox4);
        chk5 = findViewById(R.id.checkbox5);

        View.OnClickListener checkBoxListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "관심분야 : ";

                if(chk1.isChecked()) {
                    text += chk1.getText().toString();
                }

                if(chk2.isChecked()) {
                    text += chk2.getText().toString();
                }

                if(chk3.isChecked()) {
                    text += chk3.getText().toString();
                }

                if(chk4.isChecked()) {
                    text += chk4.getText().toString();
                }

                if(chk5.isChecked()) {
                    text += chk5.getText().toString();

                }

                textView.setText(text);
            }
        };

        chk1.setOnClickListener(checkBoxListener);
        chk2.setOnClickListener(checkBoxListener);
        chk3.setOnClickListener(checkBoxListener);
        chk4.setOnClickListener(checkBoxListener);
        chk5.setOnClickListener(checkBoxListener);
    }
}