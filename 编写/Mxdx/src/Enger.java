import java.util.Date;


public class Enger {
	double zongJ;
	double shiJ;
	public void ngr(){
		System.out.println(shiJ+" "+zongJ);
		 int ngr12=(int)(shiJ/zongJ*100);
		 System.out.println("�����ϵ��Ϊ:"+ngr12);
		 if(59<=ngr12){
			 System.out.println("ƶ��");
		 }else if(50<=ngr12&&ngr12<59){
			 System.out.println("�±�");
		 }else if(40<=ngr12&&ngr12<50){
			 System.out.println("С��");
		 }else if(30<=ngr12&&ngr12<40){
			 System.out.println("��ԣ");
		 }else{
			 System.out.println("�ԣ");
		 }
	}
	
	public static void main(String[] args) {
		Enger e=new Enger();
		
	}
}
