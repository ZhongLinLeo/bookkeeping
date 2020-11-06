package cn.leo.bookkeeping.bean.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 *
 * @author create by leo.zl on 2020/8/15
 */
@Data
public class UserInfo implements Serializable {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户手机号码
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String mail;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户密码
     */
    private String userPassword;

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