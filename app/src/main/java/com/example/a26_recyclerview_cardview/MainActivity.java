package com.example.a26_recyclerview_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnCardItemSelectedListener {

    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //데이터
        List<CardViewModel> cardViewModelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cardViewModelList.add(new CardViewModel(i + "번째 제목", i + "번째 내용"));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //어댑터
        mMyAdapter = new MyAdapter(cardViewModelList);

        //리사이클러뷰는 레이아웃 매니져를 달아줘야함.
        //레이아웃 매니져로 리시트뷰, 그리드뷰, 스태거뷰를 바꿔줄 수 있다.
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2, RecyclerView.VERTICAL,false);

        //애니메이션 정의
        //애니메이션은 나중에 따로 조사
        DefaultItemAnimator animator = new DefaultItemAnimator();
        //추가 애니메이션 1초(페이드인)
        animator.setAddDuration(1000);
        //제거 애니메이션 1초(페이드아웃)
        animator.setRemoveDuration(1000);
        //페이드인, 페이드아웃과 같이 이동
        animator.setMoveDuration(1000);
        //전체
        animator.setChangeDuration(10000);
        //데코레이션(나중에 조사)
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        //연결
        recyclerView.setAdapter(mMyAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(animator);
        recyclerView.addItemDecoration(decoration);


        //클릭 리스너 구현
        mMyAdapter.setOnCardItemSelected(this);
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
        //아이템 추가 메소드
        mMyAdapter.removeItem(position);

    }

    @Override
    public void onLearnSelected(int position) {
        Toast.makeText(this, position + "번째 Learn 클릭됨", Toast.LENGTH_SHORT).show();
        //아이템 제거 메소드
        mMyAdapter.addItem(position, new CardViewModel("추가됨", "추가됨"));


    }
}