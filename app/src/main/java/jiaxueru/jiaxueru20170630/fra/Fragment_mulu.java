package jiaxueru.jiaxueru20170630.fra;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
 * data 2017/6/30  16:30.
 * author:贾雪茹
 * function:
 */

public class Fragment_mulu extends Fragment {
    private ListView lv;
    private List<String> list;
    private List<JsonBean.LayoutsBean.ListBean> datalist;
    private TextView text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mulu,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view= LayoutInflater.from(getActivity()).inflate(R.layout.popup,null);
                ListView popLv= (ListView) getView().findViewById(R.id.popup_lv);
                PopupWindow window=new PopupWindow(view);
                //把新闻的标题取出来放进到集合里。给这个listview适配
                //然后做点击事件.百度popupWindow有好多
                //点击的时候做判断。如果点的是第一个。就去加载datalist的第一条数据
            }
        });
    }

    private void initData() {
        list=new ArrayList<>();
        datalist=new ArrayList<>();
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
                    //标题集合,popup的
                    list.add(layouts.get(i).getName());
                    //listview
                    datalist.add(layouts.get(i).getList().get(i));
                }


            }
        });
    }

    private void initView() {
        lv= (ListView) getView().findViewById(R.id.lv);
        text= (TextView) getView().findViewById(R.id.mulu);
    }
}
