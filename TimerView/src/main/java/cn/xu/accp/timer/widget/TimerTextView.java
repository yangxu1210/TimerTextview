package cn.xu.accp.timer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * 倒计时显示的Textview
 * Created by Xu on 2016/11/4.
 */
public class TimerTextView extends TextView implements Runnable {

    public String TAG = TimerTextView.class.getSimpleName();
    public boolean DEG = true;
    public int time = -1;//结束时间(秒) time=endTime-beginTime
    public ParentRefreshDataCallback refreshDataCallback = null;
    private Handler handler = new Handler(Looper.getMainLooper());

    public TimerTextView(Context context) {
        super(context);
    }

    public TimerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimerTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTime(int countDownTime) {
        time = countDownTime;
        handler.post(this);
    }

    public void removeRun() {
        handler.removeCallbacks(this);
    }

    public void setRefreshDataCallback(ParentRefreshDataCallback refreshDataCallback) {
        this.refreshDataCallback = refreshDataCallback;
    }


    @Override
    public void run() {
        if (time > 0) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    setText(getDate() + "后倒计时结束");
                }
            });
            time -= 1;
            handler.postDelayed(this, 1 * 1000);
        } else if (time == 0) {//time==0时,倒计时结束 调用回调刷新数据 适配器再往act里传递事件触发数据刷新操作
            time = -1;
            if (refreshDataCallback != null)
                refreshDataCallback.parentRefreshData();
        }
    }

    private String getDate() {
        int hour = 0;
        int minute = 0;
        int second = 0;
        hour = time / 3600;
        minute = time % 3600 / 60;
        second = time % 60;
        StringBuilder sb = new StringBuilder("");
        if (hour != 0) {
            sb.append(hour + "时");
        }
        if (minute != 0) {
            sb.append(minute + "分");
        }
        if (second != 0) {
            sb.append(second + "秒");
        }
        Log.e(TAG, sb.toString());
        return sb.toString();
    }
}