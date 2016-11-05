package cn.xu.accp.timer.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Xu on 2016/11/4.
 */
public class TimeUtil {

    /**
     * 日期 转换成时间戳
     * @param date
     * @return
     */
    public static  long date2Timestamp(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//yyyy年MM月dd日HH时mm分ss秒 yyyy-MM-dd HH:mm:ss
        Date d;
        try {
            d=sdf.parse(date);
            long l = d.getTime();
            return l;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 根据一个指定的时间戳 和当前时间戳 求相差值  换算成 x天x小时x分钟x秒
     * @param timestamp 指定的时间
     */
    public static String getDifferenceToSecond(long timestamp){
        StringBuffer sb=new StringBuffer();
        long days = timestamp / (1000 * 60 * 60 * 24);// 天数
        long hours = (timestamp-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);// 小时
        long minutes = (timestamp-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);// 分钟
        long second= timestamp/1000%60;// 秒
        if(days>0){
            sb.append(days+"天");
        }
        if(hours>0){
            sb.append(hours+"小时");
        }
        if(minutes>0){
            sb.append(minutes+"分");
        }
        if(second>0){
            sb.append(second+"秒");
        }
        return sb.toString();
    }
}
