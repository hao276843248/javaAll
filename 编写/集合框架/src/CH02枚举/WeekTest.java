package CH02ö��;

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
				System.out.println("������!�빤����");
				break;
			case SAT:
				System.out.println("�����������Ϣ������Ӱ��");
				break;
			case SUN:
				System.out.println("����˯�� �����ϰ࣡");
				break;
			default:
				System.out.println("����ֻ��1-7��");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		WeekTest wd=new WeekTest();
		wd.dowhat(week.THR);
	}
}
















