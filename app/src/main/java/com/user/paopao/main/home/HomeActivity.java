package com.user.paopao.main.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.user.paopao.R;
import com.user.paopao.base.BaseActivity;
import com.user.paopao.entity.HomeEntity;
import com.user.paopao.main.home.adapter.HomeAdapter;
import com.user.paopao.widget.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout llContext;
    private TextView btGirl;
    private TextView btBoy;
    private RecyclerView mRecycler;

    private HomeAdapter homeAdapter;
    private List<HomeEntity> list = new ArrayList<>();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_home);

    }

    @Override
    protected void initViews() {
        llContext = (LinearLayout) findViewById(R.id.ll_context);
        btGirl = (TextView) findViewById(R.id.bt_girl);
        btBoy = (TextView) findViewById(R.id.bt_boy);
        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);

        btGirl.setBackgroundResource(R.drawable.bt_home_top_selected);
        btGirl.setTextColor(getResources().getColor(R.color.c_ffffff));

        homeAdapter = new HomeAdapter(null);
        homeAdapter.openLoadAnimation();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setAdapter(homeAdapter);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
//        mRecycler.addItemDecoration(new SpacesItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        mRecycler.setNestedScrollingEnabled(false);

    }

    @Override
    protected void initDatas() {
        super.initDatas();
        list.clear();
        for (int i = 0; i < 5; i++) {
            HomeEntity entity = new HomeEntity();
            switch (i) {
                case 0:
                    entity.setTitle("颜值女神");
                    break;
                case 1:
                    entity.setTitle("特邀");
                    break;
                case 2:
                    entity.setTitle("御姐");
                    break;
                case 3:
                    entity.setTitle("萝莉");
                    break;
            }
            list.add(entity);
        }
        homeAdapter.setNewData(list);

    }

    @Override
    protected void initListeners() {
        super.initListeners();
        btGirl.setOnClickListener(this);
        btBoy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_girl:
                btGirl.setBackgroundResource(R.drawable.bt_home_top_selected);
                btBoy.setBackgroundResource(R.drawable.bt_home_top_normal);
                btGirl.setTextColor(getResources().getColor(R.color.c_ffffff));
                btBoy.setTextColor(getResources().getColor(R.color.c_000000));

                break;
            case R.id.bt_boy:
                btGirl.setBackgroundResource(R.drawable.bt_home_top_normal);
                btBoy.setBackgroundResource(R.drawable.bt_home_top_selected);
                btGirl.setTextColor(getResources().getColor(R.color.c_000000));
                btBoy.setTextColor(getResources().getColor(R.color.c_ffffff));

                break;
        }
    }
}