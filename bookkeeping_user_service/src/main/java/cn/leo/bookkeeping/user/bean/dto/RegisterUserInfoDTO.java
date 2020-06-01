package cn.leo.bookkeeping.user.bean.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 注册用户所需的参数
 *
 * @author leo.zl on 2020/6/1
 */
@Data
public class RegisterUserInfoDTO implements Serializable {

    /**
     * 用户名称
     */
    @NotBlank(message = "user_name 不能为空")
    @Size(min = 3,message = "user_name 长度最少为3")
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
     * 用户手机号码
     */
    @NotBlank(message = "phone_number 不能为空")
    @Pattern(regexp = "^1([34578])(0-9){9}$",message = "手机号码校验不通过")
    @SerializedName("phone_number")
    private String phoneNumber;

    /**
     * 用户邮箱
     */
    @SerializedName("email")
    private String email;

}
