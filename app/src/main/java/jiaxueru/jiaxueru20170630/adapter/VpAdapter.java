package jiaxueru.jiaxueru20170630.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * data 2017/6/30  16:32.
 * author:贾雪茹
 * function:
 */

public class VpAdapter extends FragmentPagerAdapter{
    private Context context;
    private List<Fragment> list;
    public VpAdapter(FragmentManager fm) {
        super(fm);
    }

    public VpAdapter(FragmentManager fm, Context context, List<Fragment> list) {
        super(fm);
        this.context = context;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }
}
