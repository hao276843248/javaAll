import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestStudent {
	public static void main(String[] args) {
		List<StudentA> stu=new ArrayList<StudentA>();
		stu.add(new StudentA("����", "Ů", 9));
		stu.add(new StudentA("����", "Ů", 5));
		stu.add(new StudentA("����", "��", 6));
		stu.add(new StudentA("����", "��", 1));
		Collections.sort(stu);
		for (int i = 0; i < stu.size(); i++) {
			StudentA a=stu.get(i);
			System.out.println(a.getID()+"-"+a.getName()+"-"+a.getGender());
		}
		
	}
}
