package CH02枚举;

public class WeekTest {
	public enum week{
		MON,TUE,WED,THR,FRI,SAT,SUN
	}
	
	public void dowhat(week day){
		
		switch(day){
			case MON:
			case TUE:
			case WED:
			case THR:
			case FRI:
				System.out.println("工作日!请工作！");
				break;
			case SAT:
				System.out.println("周六你可以休息看个电影！");
				break;
			case SUN:
				System.out.println("周日睡觉 明天上班！");
				break;
			default:
				System.out.println("地球只有1-7！");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		WeekTest wd=new WeekTest();
		wd.dowhat(week.THR);
	}
}
















