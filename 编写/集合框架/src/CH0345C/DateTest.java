package CH0345C;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��   HHʱmm��ss��");
		System.out.println("��ǰʱ��Ϊ��"+sdf.format(date));
	}
}
