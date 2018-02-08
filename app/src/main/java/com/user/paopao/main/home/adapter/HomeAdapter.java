package com.user.paopao.main.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.user.paopao.R;
import com.user.paopao.entity.HomeEntity;

import java.util.List;

/**
 * author :kira
 * date: 2018/2/8.
 * description:
 */

public class HomeAdapter extends BaseQuickAdapter<HomeEntity, BaseViewHolder> {

    public HomeAdapter(@Nullable List<HomeEntity> data) {
        super(R.layout.item_home, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeEntity item) {

    }
}
