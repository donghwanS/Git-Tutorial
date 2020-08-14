package com.example.ex08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 데이터 생성
        ArrayList<WeatherVO> data = new ArrayList<WeatherVO>();
        data.add(new WeatherVO("서울", "27도", "비"));
        data.add(new WeatherVO("대전", "30도", "흐림"));
        data.add(new WeatherVO("춘천", "25도", "비"));
        data.add(new WeatherVO("청주", "30도", "흐림"));
        data.add(new WeatherVO("강릉", "26도", "비"));
        data.add(new WeatherVO("대구", "33도", "흐림"));
        data.add(new WeatherVO("전주", "31도", "맑음"));
        data.add(new WeatherVO("광주", "31도", "맑음"));
        data.add(new WeatherVO("부산", "29도", "흐림"));
        data.add(new WeatherVO("제주", "32도", "맑음"));

        // 2. 어댑터 생성 .. 데이터를 가져오기 위함
        WeatherAdapter adapter = new WeatherAdapter(data);

        // 3. 뷰와 어댑터 연결결
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}