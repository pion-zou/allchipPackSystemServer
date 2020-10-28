package com.allchip.pack.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Author: 肖仕林
 * Version: 1.0.0
 * Date: 2016/12/2
 * Mender:
 * Modify:
 * Description:时间工具类
 */
public class TimeUtils {
    /**
     * @return timeString HH:mm
     */
    public static String LongToString_HHmm(long timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Date date = new Date(timestamp);
        return format.format(date);
    }

    /**
     * @return timeString MM-dd HH:mm
     */
    public static String LongToString_MMddHHmm(long timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
        Date date = new Date(timestamp);
        return format.format(date);
    }

    /**
     * @return timeString yyyy-MM-dd HH:mm
     */
    public static String LongToString_yyyyMMddHHmm(long timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        Date date = new Date(timestamp);
        return format.format(date);
    }


    /**
     * 把一种格式的日期转化为另一种格式的日期
     *
     * @param timestr
     * @param fromFormatType
     * @param toformatType
     * @return
     */
    public static String formatTime(String timestr, String fromFormatType, String toformatType) {
        String format;
        try {
            //"yyyy-MM-dd HH:mm:ss"
            SimpleDateFormat sdf = new SimpleDateFormat(fromFormatType);
            Date date = sdf.parse(timestr);
            long time = date.getTime();

            SimpleDateFormat formater = new SimpleDateFormat(toformatType);
            format = formater.format(new Date(time));
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @param time
     * @param formatType yyyy-MM-dd
     * @return
     */
    public static String formatTime(long time, String formatType) {
        String format;
        try {
            SimpleDateFormat formater = new SimpleDateFormat(formatType);
            format = formater.format(new Date(time));
            return format;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 判断是否是今年
     *
     * @param timestamp 时间戳 毫秒数
     * @return
     */
    public static boolean isThisYear(long timestamp) {
        try {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(new Date(timestamp));
            int year1 = calendar1.get(Calendar.YEAR);

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            int thisYear = calendar2.get(Calendar.YEAR);

            if (year1 == thisYear) {
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 是否是当月
     *
     * @param timestamp 时间戳 毫秒数
     * @return
     */
    public static boolean isThisMonth(long timestamp) {
        try {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(new Date(timestamp));
            int month1 = calendar1.get(Calendar.MONTH);

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            int thisMonth = calendar2.get(Calendar.MONTH);

            if (month1 == thisMonth) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static final int getTimestampInSeconds() {
        return (int) (System.currentTimeMillis() / 1000);
    }


    public static boolean isSameDay(long preTime, long otherTime) {
        if (preTime == 0 || otherTime == 0) {
            return false;
        } else {
            Calendar pre = Calendar.getInstance();
            pre.setTimeInMillis(preTime);
            Calendar other = Calendar.getInstance();
            other.setTimeInMillis(otherTime);
            return pre.get(Calendar.YEAR) == other.get(Calendar.YEAR)
                    && pre.get(Calendar.DAY_OF_YEAR) == other.get(Calendar.DAY_OF_YEAR);
        }
    }

    /**
     * 把秒 格式化为分钟：秒
     *
     * @param seconds
     * @return
     */
    public static String getMinAndSecondFormate(int seconds) {
        int min = seconds % 3600 / 60;
        int second = seconds % 60;
        return String.format(Locale.CHINA, "%02d:%02d", min, second);
    }

    /***
     *  获取当前星期几
     * @return
     */
    public static int getWeekOfDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal.get(Calendar.DAY_OF_WEEK);
    }


    /***
     *  根据出生日期计算年龄
     * @param birthday 出生日期
     * @return 年龄
     */
    public static String getAge(Date birthday) {
        if (birthday == null)
            return "";
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {//出生日期不合法
            return "";
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);
        int yearBorn = cal.get(Calendar.YEAR);
        int monthBorn = cal.get(Calendar.MONTH);
        int dayOfMonthBorn = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBorn;
        if (monthNow <= monthBorn) {
            if (monthNow == monthBorn) {
                if (dayOfMonthNow < dayOfMonthBorn)
                    age--;
            } else {
                age--;
            }
        }
        return age + "";
    }

    /**
     * 获取当前UNIX毫秒时间戳
     *
     * @return UNIX毫秒时间戳
     */
    public static long getNowUNIXTimeMills() {
        return System.currentTimeMillis() / 1000L;
    }


    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前毫秒时间戳
     *
     * @return 毫秒时间戳
     */
    public static long getNowTimeMills() {
        return System.currentTimeMillis();
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param millis 毫秒时间戳
     * @return 时间字符串
     */
    public static String millis2String(long millis) {
        return millis2String(millis, DEFAULT_PATTERN);
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为pattern</p>
     *
     * @param millis  毫秒时间戳
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String millis2String(long millis, String pattern) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * 将UNIX时间戳转为时间字符串
     * <p>格式为pattern</p>
     *
     * @param unix    unix时间戳
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String unix2String(long unix, String pattern) {
        return millis2String(unix * 1000, pattern);
    }

    /**
     * 服务返回的所有时间戳都是秒，本地转换成毫秒
     *
     * @param millis
     * @return
     */
    public static long getMillsBySecond(long millis) {
        return millis * 1000;
    }


    /**
     * 是否是今天
     *
     * @param timestamp 时间戳 毫秒数
     */
    public static boolean isToday(long timestamp) {
        try {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(new Date(timestamp));
            int day1 = calendar1.get(Calendar.DAY_OF_MONTH);

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            int thisDay = calendar2.get(Calendar.DAY_OF_MONTH);

            if (day1 == thisDay) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 秒数转化天数描述
     *
     * @return 15d 5h 56m 21s
     */
    public static String second2Day(long value) {
        int day = (int) (value / 86400L);
        int hour = (int) ((value - (day * 86400L)) / 3600L);
        int minute = (int) ((value - (day * 86400L) - (hour * 3600L)) / 60);
        int second = (int) (value - (day * 86400L) - (hour * 3600L) - (minute * 60));
        return day + "d " + hour + "h " + minute + "m " + second + "s";

    }

    /**
     * 日期格式字符串转换成时间戳(当前时区)
     *
     * @param date_str
     * @param format
     * @return
     */
    public static long date2TimeStamp(String date_str, String format) {

        SimpleDateFormat utcFormater = new SimpleDateFormat(format);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));//时区定义并进行时间获取
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(date_str);
            return gpsUTCDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 将指定的时间戳转换到 几天后的时间戳
     *
     * @param timestamp 时间戳
     * @param num       指定的天数
     * @return
     */
    public static long convertTime(long timestamp, int num) {
        try {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date(timestamp));
            calendar2.add(Calendar.DAY_OF_MONTH, num);
            long time2 = calendar2.getTime().getTime();
            return time2;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 获取当地时区
     *
     * @return
     */
    public static String getTimeZone() {
        TimeZone tz = TimeZone.getDefault();
        return tz.getID();
    }
}
