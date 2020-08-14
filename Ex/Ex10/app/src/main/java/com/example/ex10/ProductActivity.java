package com.example.ex10;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ex10.dao.ProductDAO;
import com.example.ex10.dto.ProductDTO;

import java.util.List;

// AndroidManifest.xml에  ProductActivity 등록
public class ProductActivity extends AppCompatActivity {

    Button btnAdd;
    ListView listView;
    ProductDAO dao;
    List<ProductDTO> list;

    // 1단계
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_product.xml를 현재 레이아웃으로 사용
        setContentView(R.layout.activity_product);

        // 리소스 연결
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        dao = new ProductDAO(this); // this: 현재클래스, context: 현재화면
        // 실행시 AndroidManifest.xml에 ProductActivity 추가 ==> <activity android:name=".ProductActivity" />
    }

    // onCreate(화면생성) -> 화면이동 -> finish(화면종료) -> onResume(화면복귀)
    // 2단계
    @Override
    protected void onResume() {
        super.onResume();
        // 2-1단계
        list =  dao.productList();
        Log.i("text", "상품목록 :" + list);

        // 4단계 아답터 생성
        myAdapter adapter = new myAdapter(this, R.layout.product_detail, list);
        listView.setAdapter(adapter);
    }

    // 5단계 상품추가버튼 클릭 .. 상품추가화면(ProductAddActivity)으로 이동
    public void btnAdd_onClick(View view) {

        Intent intent = new Intent(this, ProductAddActivity.class);
        startActivity(intent);
    }

    // 3단계 커스텀 아답터
    // 내부클래스
    // 커스텀 아답터 : 화면에 아답터를 만들어서 리스트뷰 출력
    class myAdapter extends ArrayAdapter<ProductDTO> {

        // 우클릭 > Generate > Constructor > 아래서 두번째
        public myAdapter(@NonNull Context context, int resource, @NonNull List<ProductDTO> objects) {
            super(context, resource, objects);
        }

        // 우클릭 > Generate > Override Method > getView 선택
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // convertView는 자식
            if(convertView == null) { // 처음 1번만 xml을 이용해서 View 생성.. 리스트가 많으면 많을수록 느려지므로
                LayoutInflater li = getLayoutInflater();
                convertView = li.inflate(R.layout.product_detail, null); // xml -> view로 객체화
            }

            // select해서 data 가져오기
            ProductDTO dto = list.get(position);

            TextView textProductName = convertView.findViewById(R.id.textProductName);
            TextView textProductPrice = convertView.findViewById(R.id.textProductPrice);
            TextView textProductAmount = convertView.findViewById(R.id.textProductAmount);

            textProductName.setText(dto.getName());
            textProductPrice.setText("가격 : " + dto.getPrice()); // String으로 변환(문자열 + int)
            textProductAmount.setText("수량 : " + dto.getAmount()); // String으로 변환(문자열 + int)

            return convertView;
        }
    }


}
