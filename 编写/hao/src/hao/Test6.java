package hao;
	/*��ϰ4����д���򣬼�������ָ��
	����˵����
	    ����ָ��(BMI)���ֳ�����ָ�����ǹ����ϳ��õĺ����������ݳ̶��뽡�����ı�׼��
	    ����ָ��������19���Ͷ����ʱ�˿����������
	    ���㹫ʽ����:
	    ����ָ��BMI=����/(���*���)    
	    ��������Բ�������ָ����20��25֮�䣬���ʾ�������У������ʾ������
	    �����Ů�Բ�������ָ����19��24֮�䣬���ʾ�������У������ʾ������
	    1.��д���򣬷ֱ�����û�������Ա���ߺ����أ����㲢����û��Ľ���״��
	    2.��������ǰӦ����Ӧ��ʾ
	    1.�����û�������ַ��������Ե���Scanner�����next()������
	    ��:String  sex = scanner.next();
	    2.�ж��ַ��������Ƿ���ȣ�Ӧ�õ���String�����equals()������
	    sex.equals("��") */
import java.util.Scanner;
public class Test6 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double Zhong;
		double gao;
		double BMI;
		String xingBie;
		do{
			System.out.println("����������Ա�(������������):");
			xingBie=input.next();
			if(xingBie.equals("��")){
				System.out.println("������������");
				gao=input.nextDouble();
				System.out.println("�������������");
				Zhong=input.nextDouble();
				BMI=Zhong/(gao*gao);
				if(20<=BMI&&BMI<=25){
					System.out.println("��������");
				}else {
					System.out.println("������");
				}
			}else if(xingBie.equals("Ů")){
				System.out.println("������������");
				gao=input.nextDouble();
				System.out.println("�������������");
				Zhong=input.nextDouble();
				BMI=Zhong/(gao*gao);
				if(19<=BMI&&BMI<=24){
					System.out.println("��������");
				}else {
					System.out.println("������");
				}
			}
		}while("��".equals(xingBie)||"Ů".equals(xingBie));
	}
	
}









