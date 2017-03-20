import java.util.Date;


public class Enger {
	double zongJ;
	double shiJ;
	public void ngr(){
		System.out.println(shiJ+" "+zongJ);
		 int ngr12=(int)(shiJ/zongJ*100);
		 System.out.println("恩格尔系数为:"+ngr12);
		 if(59<=ngr12){
			 System.out.println("贫困");
		 }else if(50<=ngr12&&ngr12<59){
			 System.out.println("温饱");
		 }else if(40<=ngr12&&ngr12<50){
			 System.out.println("小康");
		 }else if(30<=ngr12&&ngr12<40){
			 System.out.println("富裕");
		 }else{
			 System.out.println("最富裕");
		 }
	}
	
	public static void main(String[] args) {
		Enger e=new Enger();
		
	}
}
