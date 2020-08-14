package com.example.ex07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 데이터 준비
        ArrayList<String> data = new ArrayList<String>();
        for(int i=0; i<30; i++) {
            data.add("data : " + i);
        }

        // 2. 어댑터 생성 .. 데이터를 가지고 오는 방법
        // simple_list_item_1 : 안드로이드가 기본적으로 제공하는 레이아웃 중 TextView 하나만 가지는
        // 레이아웃을 가리키는 id(내부적으로 int형으로 제공됨)로 간단하게 문자열을 표시할 때 사용하기 적합
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        // 3. 뷰와 어댑터 연결
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // 4. 클릭 이벤트 추가
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, i + "번째 아이템 선택", Toast.LENGTH_SHORT).show();
            }
        });
    }
}