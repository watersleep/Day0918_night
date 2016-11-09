package program.day0918_night;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class MyAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> ilist;
    private ArrayList<String> tlist;


    public MyAdapter(FragmentManager fm, ArrayList<Fragment> ilist, ArrayList<String> tlist) {
        super(fm);
        this.ilist = ilist;
        this.tlist = tlist;
    }

    @Override
    public Fragment getItem(int position) {
        return ilist.get(position);
    }

    @Override
    public int getCount() {
        return ilist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tlist.get(position);
    }
}
