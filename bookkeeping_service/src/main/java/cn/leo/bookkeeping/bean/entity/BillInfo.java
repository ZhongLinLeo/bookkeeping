package cn.leo.bookkeeping.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 账单信息
 *
 * @author create by leo.zl on 2020/8/15
 */
@Data
public class BillInfo implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 记录类型id
     */
    private Long recordTypeId;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 账单图片
     */
    private String billPicture;

    /**
     * 金额
     */
    private Integer amount;

    /**
     * 分类
     */
    private String sort;

    /**
     * 消费时间
     */
    private LocalDateTime consumptionTime;

    /**
     * 借出人
     */
    private String borrower;

    /**
     * 借入人
     */
    private String lender;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识
     */
    private int deleteMark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
