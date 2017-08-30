package com.example.dell.tabhost_viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener,ViewPager.OnPageChangeListener
{
    ViewPager viewPager;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabHost = (TabHost) findViewById(R.id.tab);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Music");
        tab1.setIndicator("music");
        tab1.setContent(new FakeContentTab(this));

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Music");
        tab2.setIndicator("album");
        tab2.setContent(new FakeContentTab(this));

        TabHost.TabSpec tab3 = tabHost.newTabSpec("Music");
        tab3.setIndicator("list");
        tab3.setContent(new FakeContentTab(this));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);

        tabHost.setOnTabChangedListener(this);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    // lắng nghe sự kiện khi click vào tabhost để change view Pager
    public void onTabChanged(String tabId) {
        int vitritab = tabHost.getCurrentTab();
        viewPager.setCurrentItem(vitritab);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    // lắng nghe sự kiện khi lướt vào view page để change tabhost
    public void onPageSelected(int position) {
        tabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class FakeContentTab implements TabHost.TabContentFactory {
        Context context;

        public FakeContentTab(Context context) {
            this.context = context;
        }

        @Override
        public View createTabContent(String tag) {
            View view = new View(context);
            view.setMinimumHeight(0);
            view.setMinimumWidth(0);
            return view;
        }
    }


}
