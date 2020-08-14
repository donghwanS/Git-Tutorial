package com.example.ex06;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

// AndroidManifest.xml에 아래처럼 DisplayMessageActivity 추가
// <activity android:name=".DisplayMessageActivity"></activity>

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Activity를 실행할 Intent를 얻어온다
        Intent intent = getIntent();

        // Intent에서 전달한 데이터를 key를 통해서 전달받는다
        String message = intent.getStringExtra("key_message");

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        // 먼저 activity_display_message.xml에 id를 추가해야 find할 수 있다
        ViewGroup layout = findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }
}
