package com.example.kosmo65;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //액션바 생성
        ActionBar actionBar = getSupportActionBar();
        //액션바 제목
        actionBar.setTitle("메뉴화면");

        Button button1 = (Button)findViewById(R.id.main_button1);
        button1.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), d_dayActivity.class);
                    startActivity(intent);
                }
            }
        );

    };
}


