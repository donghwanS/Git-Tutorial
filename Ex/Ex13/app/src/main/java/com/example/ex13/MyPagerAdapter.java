package com.example.ex13;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
* 작성순서 5) 뷰페이지 어댑터 작성 : 뷰페이지에 내용을 표시하기 위한 어댑터 작성
* New > Java Class > Name : MyPagerAdapter, super class : FragmentPgerAdapter > OK
* 6) public 클릭 > 빨간 전구 > [Implement Methods] > 선택된 2개 메소드 확인 후 OK
* 7) public 클릭 > 빨간 전구 > [Create Constructor matching super] 또는 Generate > Constructor*
*/

public class MyPagerAdapter extends FragmentPagerAdapter {

    // 작성순서 8) ArrayList 변수 선언
    private ArrayList<Fragment> mData;

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

        // 작성순서 9) 두가지 프레그먼트를 준비 : 두가지 프레그먼트를 생성해서 ArrayList에 추가
        mData = new ArrayList<Fragment>();
        mData.add(new ColorFragment());
        mData.add(new ItemFragment());
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        // 작성순서 10) ArrayList에서 index에 해당하는 값을 가져온다
        return mData.get(position);
    }

    @Override
    public int getCount() {
        // 작성순서 11) ArrayList 사이즈 가져온다
        return mData.size();
    }

    // 작성순서 19) 각 페이지의 타이틀을 정의하는 콜백메소드 생성
    // 우클릭 > Generate > Override Methods > getPageTitle
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { // 타이틀 정의
        return position + "번째";
    }

    // 작성순서 20) 실행 : ㄱ.뷰페이지 - 좌우 슬라이딩 테스트
    //                     ㄴ.탭 - 클릭하면 해당 페이지로 이동
}
