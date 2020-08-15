package cn.leo.bookkeeping.user.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 记账类型信息实体
 *
 * @author create by leo.zl on 2020/8/15
 */
@Data
public class RecordTypeInfo implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 记录类型的id
     */
    private Long recordTypeId;

    /**
     * 记录类型的描述
     */
    private String recordTypeDescription;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识
     */
    private Byte deleteMark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}