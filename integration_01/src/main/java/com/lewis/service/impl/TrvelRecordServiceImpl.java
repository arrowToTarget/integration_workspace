package com.lewis.service.impl;

import com.lewis.dao.ITravelRecordDao;
import com.lewis.service.ITravelRecordService;
import com.lewis.util.CacheUtil;
import com.lewis.util.JsonUtil;
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

    @Resource
    private CacheUtil cacheUtil;

    public List<TravelRecord> getAllTravelRecord() {
        String allTravelRecordList = cacheUtil.getCache("allTravelRecord");
        if (allTravelRecordList != null && allTravelRecordList.length() > 0) {
            List<TravelRecord> travelRecords = JsonUtil.toList(allTravelRecordList, TravelRecord.class);
            return travelRecords;
        }
        List<TravelRecord> travelRecords = travelRecordDao.queryAllTravelRecord();
        if (travelRecords != null && travelRecords.size() > 0) {
            cacheUtil.setCache("allTravelRecord",travelRecords,600);
        }
        return travelRecords;
    }
}
