package cn.leo.bookkeeping.api.request;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 账单请求体
 *
 * @author create by leo.zl on 2020/8/13
 */
@Data
public class BillRecordRequestDto implements Serializable {

    /**
     * 记录类型的id
     */
    private String recordTypeId;

    /**
     * 记账图片
     */
    private String picture;

    /**
     * 金额
     */
    private Integer amount;

    /**
     * 分类
     */
    private String sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 账户id
     */
    private String accountId;

    /**
     * 消费时间
     */
    private LocalDateTime consumptionTime;

    /**
     * 借入人
     */
    private String borrower;

    /**
     * 借出人
     */
    private String lender;

}
