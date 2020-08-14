package com.example.ex03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    RadioGroup rg1, rg2;
    RadioButton rb1, rb2, rb3, rb4, rb;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);

        rg1 = findViewById(R.id.radioGroup1);
        // 성별
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i != -1) {
                    rb = findViewById(i);
                    if(rb != null) {
                        tv1.setText("성별 : " + rb.getText().toString());
                    } else {
                        tv1.setText("성별 : 선택안함");
                    }
                } else {
                    tv1.setText("성별 : 선택안함");
                }
            }
        });

        rg2 = findViewById(R.id.radioGroup2);
        // 메일
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
               if(i != -1) {
                   rb = findViewById(i);
                   if(rb != null) {
                       tv2.setText("메일/SNS 수신 : " + rb.getText().toString());
                   } else {
                       tv2.setText("메일/SNS 수신 : 선택안함");
                   }
               } else {
                   tv2.setText("메일/SNS 수신 : 선택안함");
               }
            }
        });

        b1 = findViewById(R.id.button1);
        // 버튼
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg1.clearCheck();
                rg2.clearCheck();
            }
        });

    }




}