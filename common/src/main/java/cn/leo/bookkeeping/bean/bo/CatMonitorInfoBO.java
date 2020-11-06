package cn.leo.bookkeeping.bean.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * cat 监控所需信息
 *
 * @author create by leo.zl on 2020/9/26
 */
@Data
public class CatMonitorInfoBO implements Serializable {

    /**
     * cat 监控类型
     */
    private String catMonitorType;

}
