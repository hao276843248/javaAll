package cn.bdqn.tangshi;

public class Test5 {
	public static void main(String[] args) {
		String str="A1B2C3D4E5F6G";
		/*str=str.replace("1","-");
		str=str.replace("2","-");
		str=str.replace("3","-");
		str=str.replace("4","-");*/
		
		str=str.replaceAll("\\d", "-");
		
		System.out.println(str);
	}
}
