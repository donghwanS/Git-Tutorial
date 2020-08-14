package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 상품목록
    public void btnList_onClick(View view) {
        // 화면 이동
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);

        // 디폴트 경로명 확인 ==> View > Tool Windows > Device File Explorer > data/data/패키지명/databases/db명
        // 예) "/data/data/com.example.ex10/database/product.db
        /*SQLiteDatabase db = openOrCreateDatabase("product.db", Context.MODE_PRIVATE, null);
        String sql = "create table if not exists product"
                    + "(p_id        integer primary key autoincrement,"
                    + " p_name      varchar2(50) not null,"
                    + " p_price     int not null,"
                    + " p_amount    int not null)";
        db.execSQL(sql);

        sql = "insert into product(p_name, p_price, p_amount) values ('노트북', 2000000, 5)";
        db.execSQL(sql);

        Toast.makeText(this, "상품 DB가 생성되었습니다", Toast.LENGTH_LONG).show();*/
    }
}