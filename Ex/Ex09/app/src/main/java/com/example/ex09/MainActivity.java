package com.example.ex09;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 리소스 연결
        // 리스트 버튼
        Button listButton = findViewById(R.id.listButton);
        listButton.setOnClickListener(new View.OnClickListener() {

            private String[] items = {"강철비2:정상회담","반도","빅샤크3:젤리 몬스터 대소동","알라딘","오케이 마담","소년시절의 너",
                                        "온워드: 단 하루의 기적 ","존 윅"};

            @Override
            public void onClick(View view) {
                // 팝업창 생성
                AlertDialog.Builder bulider = new AlertDialog.Builder(MainActivity.this);
                bulider.setTitle("국내박스오피스 영화");

                // 팝업창의 리스트 내용
                bulider.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 리스트의 황목을 클릭하면, 그 값을 토스트에 뿌린다
                        Toast.makeText(MainActivity.this, items[i], Toast.LENGTH_LONG).show();

                    }
                });

                // 다이얼로그 객체 할당 후 보여주기
                AlertDialog alertDialog = bulider.create();
                alertDialog.show();

            }
        });

        // 종료 버튼
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //팝업창 생성
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("종료하시겠습니까?");
                builder.setTitle("종료")
                        .setCancelable(false) // 사용자가 임의종료 불가

                        // Yes를 누르면 실행프로그램 종료
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })

                        // No를 누르면 팝업창 종료
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                
                // 다이얼로그 객체 할당 후 보여주기
                AlertDialog alert = builder.create();
                alert.setTitle("종료");
                alert.show();
            }
        });
    }
}