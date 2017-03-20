import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class test5 {
	public static void main(String[] args) {
		Map<String, StudentA> stu=new HashMap<String, StudentA>();
		stu.put("henry", new StudentA("好像是", "男", 123654));
		stu.put("anni", new StudentA("安妮", "女", 555555));
		stu.put("Jinks", new StudentA("金克斯", "女", 54545454));
		stu.put("Liqing", new StudentA("盲僧", "男", 6666654));
		
		Set< String > keys=stu.keySet();
		for(String a:keys){
			StudentA c=stu.get(a);
			System.out.println(a+"---"+"["+c.getName()+","+c.getGender()+","+c.getID()+"]");
		}
		
		
	}
}
