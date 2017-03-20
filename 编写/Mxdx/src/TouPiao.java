import java.util.Scanner;
public class TouPiao {
	private String name[];
	Scanner input=new Scanner(System.in);
	public void tianJ(){
		String a;
		do{
		 int i=0;
			System.out.println("ÊÇ·ñ¼ÌÐø(y/n)");
			a=input.next();
			if(a.equalsIgnoreCase("y")){
				
			}
		}while(true);
	}
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
}
