package CH0345C;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日   HH时mm分ss秒");
		System.out.println("当前时间为："+sdf.format(date));
	}
}
