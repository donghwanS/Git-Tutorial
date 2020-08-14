package com.example.ex10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ex10.dao.ProductDAO;
import com.example.ex10.dto.ProductDTO;

// AndroidManifest.xml에  ProductAddActivity 등록
public class ProductAddActivity extends AppCompatActivity {

    EditText editProductName, editProductPrice, editProductAmount;
    Button btnSave;
    ProductDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        setContentView(R.layout.activity_product_add);

        editProductName = findViewById(R.id.editProductName);
        editProductPrice = findViewById(R.id.editProductPrice);
        editProductAmount = findViewById(R.id.editProductAmount);
        btnSave = findViewById(R.id.btnSave);

        dao = new ProductDAO(this);

        // 저장버튼 클릭시 이벤트 처리
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = editProductName.getText().toString();
                int productprice = Integer.parseInt(editProductPrice.getText().toString());
                int productamount = Integer.parseInt(editProductAmount.getText().toString());

                dao.insert(new ProductDTO(productName, productprice, productamount));
                finish(); // 현재 액티비티 종료함, 이전화면 ProductActivity의 onResume()호출
            }
        });


    }

}
