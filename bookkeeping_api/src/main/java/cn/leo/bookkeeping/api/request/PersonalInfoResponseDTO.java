package cn.leo.bookkeeping.api.request;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author create by leo.zl on 2020/11/9
 */
@Data
public class PersonalInfoResponseDTO {
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
}
