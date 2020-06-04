package cn.leo.bookkeeping.user.bean.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户个人信息实体类
 *
 * @author leo.zl on 2020/5/31
 */
@Data
public class PersonalInfo implements Serializable {

    /**
     * 主键id
     */
    @SerializedName("id")
    private Long id;

    /**
     * 用户id
     */
    @SerializedName("user_id")
    private Long userId;

    /**
     * 用户名称
     */
    @SerializedName("user_name")
    private String userName;

    /**
     * 用户手机号码
     */
    @SerializedName("phone_number")
    private Integer phoneNumber;

    /**
     * 用户邮箱
     */
    @SerializedName("email")
    private String email;

    /**
     * 用户图像url
     */
    @SerializedName("user_picture")
    private String userPicture;

    /**
     * 用户签名信息
     */
    @SerializedName("user_signature")
    private String userSignature;

    /**
     * 加密信息
     */
    @SerializedName("encryption_info")
    private String encryptionInfo;

    /**
     * token
     */
    @SerializedName("token")
    private String token;

    /**
     * 是否删除 0显示 1删除
     */
    @SerializedName("is_delete")
    private Integer isDelete;

    /**
     * 订单创建时间
     */
    @SerializedName("create_time")
    private Date createTime;

    /**
     * 订单更新时间
     */
    @SerializedName("update_time")
    private Date updateTime;
}
