package cn.leo.bookkeeping.user.dao;

import cn.leo.bookkeeping.user.bean.entity.PersonalInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author leo.zl on 2020/6/1
 */
public interface PersonalInfoDao {

    /**
     * 判断是否能够根据手机号码查询到相关用户
     *
     * @param phoneNumber 手机号码
     * @return 是否存在用户
     */
    Boolean countUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);


    /**
     * 插入新用户
     *
     * @param personalInfo 用户信息
     * @return 返回是否插入成功
     */
    Boolean saveNewUser(PersonalInfo personalInfo);

}
