import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		List gou=new ArrayList();
		gou.add(new Gou("ŷŷ","ѩ����"));
		gou.add(new Gou("����","��������"));
		gou.add(new Gou("�Ʒ�","��������"));
		gou.add(new Gou("����","ѩ����"));
		System.out.println("�ܹ���"+gou.size()+"����"+"\n�ֱ���");
		for(Object obj:gou){
			Gou a=(Gou)obj;
			System.out.println(a.getName()+"\t"+a.getLei());
		}
		Scanner input=new Scanner(System.in);
		
		System.out.println("ɾ��ǰ����"+gou.size()+"����");
		System.out.println("��ѡ��Ҫɾ���ڼ����Ĺ���:");
		int c=input.nextInt();
		gou.remove(c-1);
		
		
		System.out.println("ɾ������"+gou.size()+"��");
		for(Object obj:gou){
			Gou a=(Gou)obj;
			System.out.println(a.getName()+"\t"+a.getLei());
		}
		
		
		
	}
}
