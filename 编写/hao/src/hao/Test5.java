package hao;
import java.util.Scanner;
	/*��ϰ3����д���򣬼�������ϵ��
	�����ϵ����ʳƷռ֧���ܶ�ռ��ͥ����֧���ܶ�ı��ء�
	���仰˵�������ϵ��ָ��������ʳƷ��Ǯռ��ͥ�ܻ����İٷ�֮���١�
	һ������Խ�ÿ��������������ʳ���֧��ռ��֧���ı��ؾ�Խ�ߣ�
	һ������Խ����ÿ��������������ʳ���֧��ռ��֧���ı��ؾ�Խ�͡�
	���㹫ʽΪ:
	�����ϵ��=ʳƷ֧�����/֧���ܽ��*100
	����Ľ����һ���ٷֱ�ֵ��
	�����ϵ����59%����Ϊƶ����
	          ��50%-59%֮��Ϊ�±�
	      ��40%-50%֮��ΪС��
	          ��30%-40%֮��Ϊ��ԣ
	          ��30%���µ�Ϊ�ԣ
	Ҫ��:
	1.��д���򣬽����û������ʳƷ֧��������֧�������㲢���ƶ���̶�
	  (1)��������ϵ��ֵ����59������ʾ��� ƶ��
	  (2)��������ϵ��ֵ����50����С�ڵ���59������ʾ��� �±�
	  (3)��������ϵ��ֵ����40����С�ڵ���50����ʾ��� С��
	  (4)��������ϵ��ֵ����30����С�ڵ���40������ʾ��� ��ԣ
	  (5)��������ϵ��ֵС�ڵ���30������ʾ��� �ԣ
	2.�����û�����ǰӦ���ʵ���ʾ
	����ʹ�ö��if�ṹ���*/
public class Test5 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double shi,zhong;
		double eGe;
		do{
			System.out.println("������ʳƷ֧�����");
			shi=input.nextDouble();
			System.out.println("������֧���ܽ��");
			zhong=input.nextDouble();
			eGe=shi/zhong*100;
			if(eGe>59){
				System.out.println("��ǰƶ��");
				System.out.println(eGe);
			}else if(50<eGe&&eGe<=59){
				System.out.println("��ǰ�±�");
				System.out.println(eGe);
			}else if(40<eGe&&eGe<=50){
				System.out.println("��ǰС��");
				System.out.println(eGe);
			}else if(30<eGe&&eGe<=40){
				System.out.println("��ǰ��ԣ");
				System.out.println(eGe);
			}else if(eGe<=30){
				System.out.println("��ǰ�ԣ");
				System.out.println(eGe);
			}
		}while(shi!=0);
	}
}



