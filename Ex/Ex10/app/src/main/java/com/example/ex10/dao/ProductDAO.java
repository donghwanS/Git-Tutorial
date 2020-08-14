package com.example.ex10.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.ex10.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    Context context; // DB를 사용할 현재 실행중인 화면
    SQLiteDatabase db; // 컨넥션

    public ProductDAO() {}
    public ProductDAO(Context context) {
        this.context = context;
    }

    public SQLiteDatabase dbconn() {

        SQLiteDatabase db = context.openOrCreateDatabase("product.db", Context.MODE_PRIVATE, null);
        String sql = "create table if not exists product"
                + "(p_id        integer primary key autoincrement,"
                + " p_name      varchar2(50) not null,"
                + " p_price     int not null,"
                + " p_amount    int not null)";
        db.execSQL(sql);

        return db;
    }

    // 상품목록 출력
    public List<ProductDTO> productList() {

        List<ProductDTO> list = new ArrayList<ProductDTO>();
        Cursor cursor = null; // 결과셋 객체(resultSet)

        try {
            db = dbconn();
            String sql = "select p_id, p_name, p_price, p_amount from product order by p_id";

            // rawQuery : select 쿼리 실행 => 자바의 executeQuery
            // execSQL : insert, update, delete 쿼리 실행 = > 자바의 executeUpdate

            cursor = db.rawQuery(sql, null); // select 쿼리 실행

            while(cursor.moveToNext()) { // 다음 레코드가 있으면
                int p_id = cursor.getInt(0);
                String p_name = cursor.getString(1);
                int p_price = cursor.getInt(2);
                int p_amount = cursor.getInt(3);

                Log.i("p_id","인덱스0 :" + p_id);
                Log.i("p_name","인덱스1 :" + p_name);
                Log.i("p_price", "인덱스2 :" + p_price);
                Log.i("p_amount","인덱스3 :" + p_amount);

                list.add(new ProductDTO(p_id, p_name, p_price, p_amount));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(cursor!=null) cursor.close();
            if(db!=null) db.close();
        }

        return list;
    }

    public void insert(ProductDTO dao) {

        try {

            db = dbconn();
            String sql = String.format("insert into product(p_name, p_price, p_amount) values "
                    +"('%s', %d, %d)", dao.getName(), dao.getPrice(), dao.getAmount());
            db.execSQL(sql);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(db!=null) db.close();
        }

    }

}
