package CH01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		//����ArrayList����
		List<String> list=new ArrayList<String>();
		//ͨ��size����������ü���Ԫ��������
		System.out.println("���ϸմ�����ʱ��Ԫ������="+list.size());
		//ͨ��add���������ڼ���ĩβ���Ԫ��;
		String e="apple";
		list.add(e);
		System.out.println("������Ӻ�Ԫ������="+list.size());
		
		String str=(String)list.get(0);
		System.out.println(str);
		
		list.add("ƻ��");
		list.add("�㽶");
		list.add("��");
		list.add("����");
		list.add("Mongo");
		
		//ͨ��add()�����ڼ����в���Ԫ��
		//����Ԫ�غ����Ԫ���±��仯
		
		list.add(2, "ri");
		list.set(3,"cacacs");
		list.remove("ri");
		
		//�ڼ�����ɾ��Ԫ�����±���д�±곬����Χ�����쳣
		list.remove(1);
		//���list����
		list.clear();
		System.out.println("��պ�ļ���Ԫ������"+list.size());
		//forѭ������
		  for (int i = 0; i < list.size(); i++) {
			String value=(String)list.get(i);
			System.out.println("��"+(i+1)+"��Ԫ��"+value);
		}
		/*��ǿforѭ��
		for(String :list ){
			String value=(String)obj;
			System.out.println(value);
		}*/
		/*����ѭ�����
		Iterator it=list.iterator();
		while(it.hasNext()){
			String value=(String)it.next();
			System.out.println(value);
		}*/
		
	}
}
