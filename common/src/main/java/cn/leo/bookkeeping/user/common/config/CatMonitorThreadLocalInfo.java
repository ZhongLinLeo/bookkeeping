package cn.leo.bookkeeping.user.common.config;

/**
 * 当前线程监控类型信息
 *
 * @author create by leo.zl on 2020/9/27
 */
public class CatMonitorThreadLocalInfo {

    private CatMonitorThreadLocalInfo(){}

    /**
     * 当前线程监控类型
     */
    private static final ThreadLocal<String> CAT_MONITOR_TYPE = new ThreadLocal<>();

    /**
     * 获取某个业务线监控的类型
     *
     * @return 当前线程cat监控的类型
     */
    public static String getCatMonitorType() {
        return CAT_MONITOR_TYPE.get();
    }

    /**
     * 某个业务线监控的类型
     *
     * @param monitorType monitorType
     */
    public static void setCatMonitorType(String monitorType) {
        CAT_MONITOR_TYPE.set(monitorType);
    }

    /**
     * 移除 catMonitorType ThreadLocal中的值
     */
    public static void removeThreadLocal() {
        CAT_MONITOR_TYPE.remove();
    }

}
