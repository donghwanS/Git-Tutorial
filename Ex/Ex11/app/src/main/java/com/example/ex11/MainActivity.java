package com.example.ex11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ColorListFragment.onColorSelectedListener {

    /*
    * 1) 메뉴 리소스 작성
    *   왼쪽 프로젝트 창 res 디렉토리 > 우클릭 > [New > Android Resource Directory] > Resource Type : menu로 변경
    *   res 디렉토리 아래에 menu 디렉토리가 생성된다
    *
    * 2) 리소스 파일 생성
    *   res/menu 디렉토리 > 우클릭 > [New - Menu resource File] > file name : menu_main 확인> menu_main.xml이 자동 생성
    *   파일명은 대문자, 맨앞 숫자, 특수기호 안된다
    * 3) menu_main.xml 작성
    *
    * 4) 메뉴 자바코드 작성
    *
    * */

    // 작성순서 11)
    private ColorFragment mColorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 작성순서 5. 리소스 연결
        /*ColorFragment colorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color);
        colorFragment.setColor(Color.RED);*/

        // 작성순서 12. 작성순서 5. 주석처리 후 추가
        mColorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color);

    }

    // 작성순서 9). 콜백 인터페이스 구현
    // implements ColorListFragment.onColorSelectedListener 추가, override method -> onColorSelected 선택
    @Override
    public void onColorSelected(int color) {
        // 작성순서 13.
        mColorFragment.setColor(color);

    }

    // 우클릭 > Generate > Override Methods > onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // MenuInflater로 메뉴를 생성하여 menu 객체에 설정
        // MenuInflater : 메뉴와 연결하기 위한 객체
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true; // 반드시 true 리턴
    }

    // 우클릭 > Generate > Override Methods > onOptionsItemSelected
    // 메뉴 클릭시 처리부분 구현
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu1 :
                Toast.makeText(this, "첫번째 메뉴", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_menu2 :
                Toast.makeText(this, "두번째 메뉴", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_menu3 :
                Toast.makeText(this, "세번째 메뉴", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_menu4 :
                Toast.makeText(this, "네번째 메뉴", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_menu5 :
                Toast.makeText(this, "다섯번째 메뉴", Toast.LENGTH_LONG).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}