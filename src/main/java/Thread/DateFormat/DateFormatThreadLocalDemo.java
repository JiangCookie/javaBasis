package Thread.DateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 不是线程安全的，DateFormat内部使用了一个Calandar实例对象，多线程同时调用时，实例状态可能会紊乱
 * 使用ThreadLocal实现线程安全
 *
 * @author JYH
 * 2018/11/26 17:07
 */
public class DateFormatThreadLocalDemo {
    static ThreadLocal<DateFormat> sdf = new ThreadLocal<DateFormat>(){

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String date2String(Date date){
        return sdf.get().format(date);
    }

    public static Date string2Date(String str) throws ParseException {
        return sdf.get().parse(str);
    }
}
