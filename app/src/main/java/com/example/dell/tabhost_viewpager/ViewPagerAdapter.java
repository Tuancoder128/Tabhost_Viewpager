package com.example.dell.tabhost_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by dell on 2017-08-30.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {

        super(fm);
    }


    @Override
    // Fragment nhận vào giá trị kiểu mảng
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment_1 fragment_1 = new Fragment_1();
                return fragment_1;
            case 1:
                Fragment_2 fragment_2 = new Fragment_2();
                return fragment_2;

            case 2:
                Fragment_3 fragment_3 = new Fragment_3();
                return fragment_3;

            default: return null;
        }
        //return null;
    }

    @Override
    // trả về độ dài số lượng Fragment
    public int getCount() {

        return 3;
    }
}
