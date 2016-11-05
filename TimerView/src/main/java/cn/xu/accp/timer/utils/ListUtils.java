package cn.xu.accp.timer.utils;

import java.util.List;

/**
 * Created by Xu on 2016/11/4.
 */
public class ListUtils {
    /**
     * 获取LIST真实大小
     *
     * @param list
     * @return
     */
    public static int getSize(List list) {
        if (list == null || list.size() < 1) {
            return 0;
        } else {
            return list.size();
        }
    }
}
