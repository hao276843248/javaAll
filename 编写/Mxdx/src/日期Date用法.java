import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class ����Date�÷� {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] a=new String[3];
		int index=0;
		try {
			//���ϵͳ��ǰ�ĺ�����
			long now=System.currentTimeMillis();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("����涨��ʽ������(yyyy-mm-dd)");
			Date date=sdf.parse(input.next());
			
			//���ָ�����ڵĺ�����
			long time=date.getTime();
			
			//�ж�ָ�������ڵ����ھ���������
			int days=(int)((now-time)/(1000L*60*60*24*365));
			
			System.out.println(days);
			
			
			
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		
		do{
			if(index==a.length){
				a=(String[])Arrays.copyOf(a, a.length+1);
			}
			System.out.println("����");
			a[index]=input.next();
			index++;
			System.out.println("y��n");
			String b=input.next();
			if(b.equals("n")){
				break;
			}
		}while(true);
		System.out.println(Arrays.toString(a));
	}
}
