package CH0345C;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datatest1 {
	public static void main(String[] args) {
		Calendar t=Calendar.getInstance();
		System.out.println("������"+t.get(Calendar.YEAR)+"��"+(t.get(Calendar.MONTH)+1)+"��"+t.get(Calendar.DAY_OF_MONTH)+"��");
		String[] a=new String[7];
		a[0]="��";a[1]="һ";a[2]="��";a[3]="��";a[4]="��";a[5]="��";a[6]="��";
		System.out.println("����������"+a[(t.get(Calendar.DAY_OF_WEEK)-1)]);
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��   HHʱmm��ss��");
		System.out.println("��ǰʱ��Ϊ��"+sdf.format(date));
	}
}
