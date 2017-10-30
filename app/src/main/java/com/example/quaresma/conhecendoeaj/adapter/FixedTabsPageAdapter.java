package com.example.quaresma.conhecendoeaj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.quaresma.conhecendoeaj.fragment.Fragment1;
import com.example.quaresma.conhecendoeaj.fragment.Fragment2;
import com.example.quaresma.conhecendoeaj.fragment.Fragment3;

public class FixedTabsPageAdapter extends FragmentPagerAdapter {


    public FixedTabsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Locais";
            case 1:
                return "Detalhes";
            case 2:
                return "Localização";
            default:
                return null;
        }
    }
}
