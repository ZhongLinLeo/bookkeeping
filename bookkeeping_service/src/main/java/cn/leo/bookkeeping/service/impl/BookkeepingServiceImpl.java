package cn.leo.bookkeeping.service.impl;

import cn.leo.bookkeeping.service.BookkeepingService;
import cn.leo.bookkeeping.bean.entity.BillInfo;
import cn.leo.bookkeeping.dao.BillInfoDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static cn.leo.bookkeeping.enums.CommonResponseEnum.SYSTEM_ERROR;

/**
 * @author create by leo.zl on 2020/8/15
 */
@Service
public class BookkeepingServiceImpl implements BookkeepingService {

    @Resource
    private BillInfoDAO billInfoDAO;

    @Override
    public void saveBillInfo(BillInfo billInfo) {

        int lines = billInfoDAO.saveBillInfo(billInfo);

        // 判断是否插入成功
        SYSTEM_ERROR.assertIsTrue(lines == 1);
    }
}
