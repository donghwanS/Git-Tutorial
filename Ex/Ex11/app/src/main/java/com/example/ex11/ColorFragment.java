package com.example.ex11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// 작성순서 -> 3. 색상을 표시하는 프래그먼트 작성
// 우클릭 > Generate > Override Methods > ColorFragment 선택
public class ColorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new View(getActivity());
    }

    public void setColor(int color) {
        getView().setBackgroundColor(color);
    }
}
