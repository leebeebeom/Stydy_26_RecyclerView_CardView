package com.example.a26_recyclerview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnCardItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<CardViewModel> cardViewModelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cardViewModelList.add(new CardViewModel(i + "번째 제목", i + "번째 내용"));
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdapter myAdapter = new MyAdapter(cardViewModelList);
        //리사이클러뷰는 레이아웃 매니져를 달아줘야함.
        //레이아웃 매니져로 리시트뷰, 그리드뷰, 스태거뷰를 바꿔줄 수 있다.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(myAdapter);
        //클릭 리스너 구현
        myAdapter.setOnCardItemSelected(this);
    }

    @Override
    public void onItemSelected(int position) {
        Toast.makeText(this, position + "번째 아이템 클릭됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTitleSelected(int position) {
        Toast.makeText(this, position + "번째 타이틀 클릭됨", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onContentsSelected(int position) {
        Toast.makeText(this, position + "번째 컨텐츠 클릭됨", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onShareSelected(int position) {
        Toast.makeText(this, position + "번째 Share 클릭됨", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLearnSelected(int position) {
        Toast.makeText(this, position + "번째 Learn 클릭됨", Toast.LENGTH_SHORT).show();


    }
}