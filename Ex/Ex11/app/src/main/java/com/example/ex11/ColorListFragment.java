package com.example.ex11;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {

    // 작성순서 -> 7) 외부 액티비티와 연결하도록
    private onColorSelectedListener mListener;

    // 작성순서 -> 6) 콜백 인터페이스 정의 : 프레그먼트에서 액티비티를 조작할 때는 콜백을 사용
    interface onColorSelectedListener {
        void onColorSelected(int color); // 추상메소드 : 어떤 동작에 의해 콜백으로 동작할 예정
    }

    // 작성순서 -> 8) Activity에 프레그먼트를 붙일때 호출됨
    // 우클릭 > Generate > Override method > onAttach
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener = (onColorSelectedListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(((Activity)context).getLocalClassName() + "는 OnColorSelectedListener를 구현해야 합니다");
        }

    }

    // 작성순서 -> 1) 색상 목록을 표시하는 프레그먼트 작성
    // 우클릭 > Generate > Override method > onViewCreated 선택
   @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList = Arrays.asList("Red", "Green", "Blue"); // ListView를 3가지로 표현

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, colorList);
        setListAdapter(adapter);

    }

    // 작성순서 10) 우클릭 > Generate > Override method > onListItemClick 선택
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;
        switch(colorString) {
            case "Red" :
                color = Color.RED;
                break;
            case "Green" :
                color = Color.GREEN;
                break;
            case "Blue" :
                color = Color.BLUE;
                break;
        }
        if(mListener != null) {
            mListener.onColorSelected(color); // 선택된 색상을 해당 리스너를 구현한 곳으로 전달한다
        }
    }
}
