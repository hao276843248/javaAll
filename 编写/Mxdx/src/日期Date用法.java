import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class 日期Date用法 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] a=new String[3];
		int index=0;
		try {
			//获得系统当前的毫秒数
			long now=System.currentTimeMillis();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("输入规定格式年月日(yyyy-mm-dd)");
			Date date=sdf.parse(input.next());
			
			//获得指定日期的毫秒数
			long time=date.getTime();
			
			//判断指定的日期到现在经过的年数
			int days=(int)((now-time)/(1000L*60*60*24*365));
			
			System.out.println(days);
			
			
			
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		
		do{
			if(index==a.length){
				a=(String[])Arrays.copyOf(a, a.length+1);
			}
			System.out.println("输入");
			a[index]=input.next();
			index++;
			System.out.println("y？n");
			String b=input.next();
			if(b.equals("n")){
				break;
			}
		}while(true);
		System.out.println(Arrays.toString(a));
	}
}
