package cn.leo.bookkeeping.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 账户信息
 *
 * @author create by leo.zl on 2020/8/15
 */
@Data
public class AccountInfo implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 账户描述
     */
    private String accountDescription;

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