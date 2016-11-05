package cn.xu.accp.timer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import cn.xu.accp.timer.utils.ListUtils;
import cn.xu.accp.timer.widget.ParentRefreshDataCallback;
import cn.xu.accp.timer.widget.TimerTextView;

/**
 * Created by Xu on 2016/11/4.
 */
public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Integer> mList;

    public ItemAdapter(Context context, ArrayList<Integer> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return ListUtils.getSize(mList);
    }

    @Override
    public Integer getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TimerTextView tv = new TimerTextView(mContext);
        tv.removeRun();
        tv.setRefreshDataCallback(new ParentRefreshDataCallback() {
            @Override
            public void parentRefreshData() {
                // 这里回调到act去刷新操作
                if (refreshListener!=null){
                    refreshListener.onRefresh();
                }
            }
        });
        tv.setTime(mList.get(i));
        return tv;
    }

    private RefreshListener refreshListener;

    public void setRefreshListener(RefreshListener refreshListener) {
        this.refreshListener = refreshListener;
    }
    public interface RefreshListener{
        void onRefresh();
    }
}

