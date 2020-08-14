package com.example.ex06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        send 버튼을 클릭했을 때 호출되는 메소드
        Intent : 다른 액티비티로 화면을 전환

     */

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class); // new Intent(현재페이지, 이동할 페이지);
        EditText editText = findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        intent.putExtra("key_message", message); // intent.putExtra(key, 값);
        startActivity(intent);

    }
}