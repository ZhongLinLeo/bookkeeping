package cn.leo.bookkeeping.user.common.constant;

import cn.leo.bookkeeping.user.common.bean.bo.CatMonitorInfoBO;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务监控常量信息
 *
 * @author create by leo.zl on 2020/9/26
 */
public class BusinessMonitorConstants {

    private static Map<String, CatMonitorInfoBO> catMonitorInfoMap;

    private BusinessMonitorConstants() {
    }

    public static CatMonitorInfoBO getCatMonitorInfo(String monitorMethodName) {
        if (catMonitorInfoMap==null){
            return null;
        }

        return catMonitorInfoMap.get(monitorMethodName);
    }

    public static void putCatMonitorInfo(String monitorMethodName, CatMonitorInfoBO catMonitorInfo) {

        if (catMonitorInfoMap == null) {
            catMonitorInfoMap = new HashMap<>(16);
        }

        catMonitorInfoMap.put(monitorMethodName, catMonitorInfo);
    }
}
