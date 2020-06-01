package cn.leo.bookkeeping.user.bean.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

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
    private String userId;

    /**
     * 用户名称
     */
    @SerializedName("user_name")
    private String userName;

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
     * 用户加密类型  1：密码，2：指纹，3：人脸
     */
    @SerializedName("encryption_type")
    private String encryptionType;

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
    private String isDelete;

    /**
     * 订单创建时间
     */
    @SerializedName("create_time")
    private String createTime;

    /**
     * 订单更新时间
     */
    @SerializedName("update_time")
    private String updateTime;
}
