package com.example.inuon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; //하단바 생성
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Chat chat;
    private Calendar calendar;
    private Map map;
    private Mypage mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_chat:
                        setFrag(0);
                        break;
                    case R.id.action_calendar:
                        setFrag(1);
                        break;
                    case R.id.action_map:
                        setFrag(2);
                        break;
                    case R.id.action_mypage:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        chat = new Chat();
        calendar = new Calendar();
        map = new Map();
        mypage = new Mypage();
        setFrag(0); //첫 프래그먼트 화면 지정
    }

    //4개 프레그먼트 교체일어나는 실행문
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case(0):
                ft.replace(R.id.main_frame, chat);
                ft.commit(); //저장
                break;
            case(1):
                ft.replace(R.id.main_frame, calendar);
                ft.commit();
                break;
            case(2):
                ft.replace(R.id.main_frame, map);
                ft.commit();
                break;
            case(3):
                ft.replace(R.id.main_frame, mypage);
                ft.commit();
                break;
        }
    }
}