package CH0345C;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datatest1 {
	public static void main(String[] args) {
		Calendar t=Calendar.getInstance();
		System.out.println("今天是"+t.get(Calendar.YEAR)+"年"+(t.get(Calendar.MONTH)+1)+"月"+t.get(Calendar.DAY_OF_MONTH)+"日");
		String[] a=new String[7];
		a[0]="日";a[1]="一";a[2]="二";a[3]="三";a[4]="四";a[5]="五";a[6]="六";
		System.out.println("今天是星期"+a[(t.get(Calendar.DAY_OF_WEEK)-1)]);
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日   HH时mm分ss秒");
		System.out.println("当前时间为："+sdf.format(date));
	}
}
