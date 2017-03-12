package cn.semiwarm.api.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * Created by alibct on 2017/3/11.
 */
public class DateUtils {
    public static String getCurrentDate(){
        Date currentDate = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(currentDate);
    }
}
