package com.example.quaresma.conhecendoeaj;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.quaresma.conhecendoeaj.adapter.FixedTabsPageAdapter;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TabLayout tabLayout;
    ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = (ImageView) findViewById(R.id.logo);


        vp = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pa = new FixedTabsPageAdapter(getSupportFragmentManager());

        vp.setAdapter(pa);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(vp);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:
                        //imageView.setImageResource(R.drawable.logomap);

                        break;
                    default:
                        return;
                }


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        if(vp.getCurrentItem() != 0){
            vp.setCurrentItem(0);
        } else {
            super.onBackPressed();
        }
    }
}
