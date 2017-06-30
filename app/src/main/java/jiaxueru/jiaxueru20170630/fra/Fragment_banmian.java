package jiaxueru.jiaxueru20170630.fra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jiaxueru.jiaxueru20170630.R;
import jiaxueru.jiaxueru20170630.bean.JsonBean;
import jiaxueru.jiaxueru20170630.utils.OkHttpUtils;
import jiaxueru.jiaxueru20170630.utils.URLUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * data 2017/6/30  16:29.
 * author:贾雪茹
 * function:
 */

public class Fragment_banmian extends Fragment {
    private ViewPager vp;
    private List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_banmian,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        list=new ArrayList<>();
        OkHttpUtils.get(URLUtils.PATH, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson=new Gson();
                JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
                List<JsonBean.LayoutsBean> layouts = jsonBean.getLayouts();
                for (int i=0;i<layouts.size();i++){
                    list.add(layouts.get(i).getPicUrl());
                }
                //团片切换。写一个公共fragment。里边放一张图。然后用glide加载图片。替换掉
//                vp.setAdapter();

            }
        });
    }

    private void initView() {
        vp= (ViewPager) getView().findViewById(R.id.vp_banmian);
    }
}
