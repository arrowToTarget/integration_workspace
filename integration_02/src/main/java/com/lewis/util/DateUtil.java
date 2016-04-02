package com.lewis.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangminghua on 2016/4/2.
 */
public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String getNowTime(){
        return sdf.format(new Date());
    }
}
