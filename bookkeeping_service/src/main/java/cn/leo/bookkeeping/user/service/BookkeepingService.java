package cn.leo.bookkeeping.user.service;

import cn.leo.bookkeeping.user.bean.entity.BillInfo;

/**
 * 记账相关服务
 *
 * @author create by leo.zl on 2020/8/15
 */
public interface BookkeepingService {

    /**
     * 保存账单信息
     *
     * @param billInfo 账单信息
     * @return 返回是否保存成功
     */
    void saveBillInfo(BillInfo billInfo);
}
