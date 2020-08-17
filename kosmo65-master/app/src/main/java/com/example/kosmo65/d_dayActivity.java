package com.example.kosmo65;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class d_dayActivity extends AppCompatActivity {
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_day);

        //액션바 생성
        ActionBar actionBar = getSupportActionBar();
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        //현재 날짜 출력
        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
        String today = format1.format(date);

        TextView textViewToday = (TextView)findViewById(R.id.today);
        textViewToday.setText("오늘 : "+today);


    }

    //액션바 뒤로가기
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home :
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}