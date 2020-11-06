package cn.leo.bookkeeping.enums;

/**
 * @author leo.zl on 2020/6/1
 */
public interface ResponseCode {

    /**
     * 获取返回码
     *
     * @return 返回码
     */
    String getResponseCode();

    /**
     * 获取返回信息
     *
     * @return 返回信息
     */
    String getResponseMessage();

}
