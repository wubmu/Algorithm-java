package 第十一届研究生_java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/*
//日历类

Calendar c = Calendar.getInstance();　　// 获取实例化对象

Date date =c.getTime(); // 日期类得到c的时间；

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");　　// 修改格式

SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");

String now =sdf.format(date);　　//  以字符串方式得到时间，用sdf修改date得到自己希望的格式

System.out.println(now);　　// 输出当前时间/日期
————————————————

 */
//https://blog.csdn.net/white1114579650/article/details/111289913
//https://www.cnblogs.com/pengsay/p/14593668.html
public class _02跑步锻炼 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 天数
        Date start = sdf.parse("2000-01-01");
        Date end = sdf.parse("2020-10-01");
        long start_long = start.getTime();
        long end_long = end.getTime();
        long oneDay = 1000 * 60 * 60 * 24;
        int ans = 0;
        while (start_long <= end_long){
            // 周一月初 + 2 其他 + 1
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(start_long));

            int dayweek  = cal.get(Calendar.DAY_OF_WEEK);
            int mon = cal.get(Calendar.MONTH);


            start_long += oneDay;
        }
        //1、注意月份，一月是0，二月是1，。。。以此类推
        //2、星期天是1，星期一是2，星期二是3，。。。以此类推
    }



}
