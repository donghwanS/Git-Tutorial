package com.example.ex08;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// New > Class > WeatherAdapter - superClass를 BaseAdapter로 지정
public class WeatherAdapter extends BaseAdapter {

    private List<WeatherVO> mData;
    // drawable 폴더에 이미지를 복사해서 붙여넣는다. 이미지는 숫자로 사용할 수 없고, 소문자여야 한다
    // Map<String, 이미지리소스ID 즉, 숫자>
    private Map<String, Integer> mWeatherImage;

    // 매개변수 생성자 .. List를 구현한 모든것(ArrayList)를 받는 생성자
    public WeatherAdapter(List<WeatherVO> mData) {
        this.mData = mData;

        // Key인 날씨정보에 따른 이미지를 설정해서 날씨정보를 이미지로 뿌리겠다
        // MainActivity의 날씨 "Key"의 모든 정보가 put되어야 한다
        mWeatherImage = new HashMap<>();
        mWeatherImage.put("비", R.drawable.rainny);
        mWeatherImage.put("맑음", R.drawable.sunny);
        mWeatherImage.put("흐림", R.drawable.cloudy);
        mWeatherImage.put("눈", R.drawable.snow);
    }

    // 아이템 갯수
    @Override
    public int getCount() {
        return mData.size();
    }

    // position번째의 아이템
    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    // position번째의 아이디
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder; // 맨아래 ViewHolder 클래스를 먼저 작성후 선언한다

        // false : 이 레이아웃이 루트 레이아웃인지를 지정한다. 리스트뷰의 각 아이템이므로 false를 지정
        if(view == null) {
            holder = new ViewHolder();

            // view : Activity 이외의 클래스에서 Context를 통해 XML로 정의한 레이아웃을 로드하여 view로 반환해주는 클래스이다
            // item_weather.xml을 로드하고, 이 레이아웃의 부모뷰그룹인 viewGroup를 지정해주고, 이 레이아웃이 루트레이아웃인지 아닌지 지정한다
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_weather, viewGroup, false);

            // 날씨, 도시명, 기본 View
            ImageView weatherImage = view.findViewById(R.id.weather_image);
            TextView cityView = view.findViewById(R.id.text_city);
            TextView tempView = view.findViewById(R.id.text_temp);

            holder.weatherImage = weatherImage;
            holder.cityText = cityView;
            holder.tempText = tempView;

            // setTag() : 모든 객체를 담을 수 있는 다용도 메소드로 특정한 목정이 없으므로 용도에 맞게 자유롭게 쓸수 있다
            view.setTag(holder); // 현재 보여지는 객체
        } else {
            holder = (ViewHolder)view.getTag(); // setTag()에 연결하여 재사용시 꺼내서 쓴다
        }

        // 현재 포지션의 날씨 데이터
        WeatherVO weather = mData.get(i);

        // 데이터를 설정할때 각 아이템의 뷰 홀더에 데이터를 설정해서 레이아웃 로드와 뷰를 찾는 동작을 최소화하여
        // ListView의 성능을 최적화할 수 있다(리스트뷰 스크롤시 느리지 않게 하기 위함.. 세션 느낌)
        holder.cityText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());
        holder.weatherImage.setImageResource(mWeatherImage.get(weather.getWeather()));

        return view;
    }

    // 내부 클래스
    // 성능 개선 클래스 viewHolder 패턴은 자주 사용하는 뷰를 한번 로드하면 재사용하고, 표시할 내용만 교체하기 위한 패턴이다
    static class ViewHolder {

        ImageView weatherImage;
        TextView cityText;
        TextView tempText;

    }

}
