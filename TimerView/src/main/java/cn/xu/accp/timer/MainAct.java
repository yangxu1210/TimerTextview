package cn.xu.accp.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainAct extends AppCompatActivity implements ItemAdapter.RefreshListener {
    private ListView lv_time_list;
    private ArrayList<Integer> list=new ArrayList<>();
    private ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        lv_time_list= (ListView) findViewById(R.id.lv_time_list);
        initData();
        adapter=new ItemAdapter(this,list);
        adapter.setRefreshListener(this);
        lv_time_list.setAdapter(adapter);
    }
    private void initData() {
        list.add(3600);
        list.add(7200);
        list.add(5000);
        list.add(6500);
    }

    @Override
    public void onRefresh() {
        Toast.makeText(this,"执行刷新操作",Toast.LENGTH_SHORT).show();
    }
}
