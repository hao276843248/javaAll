import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestStudent {
	public static void main(String[] args) {
		List<StudentA> stu=new ArrayList<StudentA>();
		stu.add(new StudentA("张三", "女", 9));
		stu.add(new StudentA("张四", "女", 5));
		stu.add(new StudentA("张五", "男", 6));
		stu.add(new StudentA("张六", "男", 1));
		Collections.sort(stu);
		for (int i = 0; i < stu.size(); i++) {
			StudentA a=stu.get(i);
			System.out.println(a.getID()+"-"+a.getName()+"-"+a.getGender());
		}
		
	}
}
