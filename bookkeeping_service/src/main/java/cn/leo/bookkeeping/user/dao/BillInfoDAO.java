package cn.leo.bookkeeping.user.dao;

import cn.leo.bookkeeping.user.bean.entity.BillInfo;
import org.springframework.stereotype.Repository;

/**
 * 账单信息的 dao 层
 *
 * @author create by leo.zl on 2020/8/15
 */
@Repository
public interface BillInfoDAO {

    /**
     * 保存账单信息
     *
     * @param billInfo 账单信息
     * @return 影响行数
     */
    int saveBillInfo(BillInfo billInfo);
}
