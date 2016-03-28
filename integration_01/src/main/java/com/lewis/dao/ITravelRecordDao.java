package com.lewis.dao;

import com.lewis.vo.TravelRecord;
import java.util.List;

/**
 * Created by zhangminghua on 2016/3/28.
 */
public interface ITravelRecordDao {

    List<TravelRecord> queryAllTravelRecord();
}
