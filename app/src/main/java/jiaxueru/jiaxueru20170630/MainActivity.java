package jiaxueru.jiaxueru20170630;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import jiaxueru.jiaxueru20170630.adapter.VpAdapter;
import jiaxueru.jiaxueru20170630.fra.Fragment_banmian;
import jiaxueru.jiaxueru20170630.fra.Fragment_mulu;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        list=new ArrayList<>();
        list.add(new Fragment_banmian());
        list.add(new Fragment_mulu());
        vp.setAdapter(new VpAdapter(getSupportFragmentManager(),this,list));
    }

    private void initView() {
        vp= (ViewPager) findViewById(R.id.vp);
    }
}
