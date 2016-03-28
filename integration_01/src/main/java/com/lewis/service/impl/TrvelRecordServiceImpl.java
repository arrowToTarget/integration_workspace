package com.lewis.service.impl;

import com.lewis.dao.ITravelRecordDao;
import com.lewis.service.ITravelRecordService;
import com.lewis.vo.TravelRecord;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/28.
 */
@Service
public class TrvelRecordServiceImpl implements ITravelRecordService {

    @Resource
    private ITravelRecordDao travelRecordDao;

    public List<TravelRecord> getAllTravelRecord() {
        return travelRecordDao.queryAllTravelRecord();
    }
}
