package com.example.ex13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ex13.dummy.DummyContent.DummyItem;
import com.google.android.material.tabs.TabLayout;

// 작성순서 13-1) ItemFragment.java에서 interface onListFragmentInteractionListener 추가
// 작성순서 13-2) 아래에 generate > override Methods > onListFragmentInteractionListener 선택 후 추가
public class MainActivity extends AppCompatActivity implements ItemFragment.onListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 작성순서 12) 뷰페이저와 아답터를 연결
        ViewPager viewpager = findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager()); // 생성자 매개변수 수정
        viewpager.setAdapter(adapter);

        // 작성순서 18) TabLayout 리소스 연결
        TabLayout tabLayout = findViewById(R.id.tab);

        // 뷰페이지와 탭레이아웃 연동
        tabLayout.setupWithViewPager(viewpager);

    }

    // 작성순서 13-2)
    @Override
    public void onListFragmentInteraction(DummyItem item) {
        Log.i("item", "item :" + item);
        // 작성순서 14) 콜백메소드 구현 : ItemFragment와 상호작용하는 콜백메소드
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();

        // 작성순서 15) 실행 : 화면을 좌우로 밀면 화면이 슬라이딩되고, 두번째 화면에서 아이템을 클릭하면 토스트메시지 출력

        /* 탭 레이아웃과 연동 */
        // 작성순서 16) Gradle Scripts > build.gradle 라이브러리에 아래 문장 추가
        // implementation 'com.android.support:design:30.0.1'


    }
}