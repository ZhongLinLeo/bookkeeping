package cn.leo.bookkeeping.user.bean.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 记账信息表对应的实体
 *
 * @author leo.zl on 2020/4/17
 */
@Data
public class BookkeepingInfo implements Serializable {

    /**
     * 主键
     */
    private String id;

    /**
     * 记账图片
     */
    private String picture;

    /**
     * 记账金额
     */
    private String amount;

    /**
     * 分类
     */
    private String sort;

    /**
     * 备注
     */
    private String mark;

    /**
     * 账户
     */
    private String account;

    /**
     *
     */
    private String bookkeepingTime;
    private String rollIn;
    private String rollOut;
    private String isDelete;
    private String createTime;
    private String updateTime;
}
