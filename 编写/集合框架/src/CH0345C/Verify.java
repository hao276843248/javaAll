package CH0345C;

import java.util.Scanner;

public class Verify {
	public static void main(String[] args) {
		boolean fileCorrect=false;
		boolean emailCorrect=false;
		System.out.println("--欢迎进入作业提交系统--");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入Java文件名：");
		String fileName=input.next();
		System.out.println("请输入你的邮箱");
		String email=input.next();
		int index=fileName.lastIndexOf(".");
		if(index!=-1 && index!=0 && fileName.substring(index+1, fileName.length()).equals("java")){
			fileCorrect=true;
		}else{
			System.out.println("文件名无效。");
		}
		
		
		if(email.indexOf('@')!=-1 && email.indexOf('.')>email.indexOf('@')){
			emailCorrect=true;
		}else{
			System.out.println("E-mail无效。");
		}
		
		if(fileCorrect&&emailCorrect){
			System.out.println("提交作业成功");
		}else{
			System.out.println("提交作业失败");
		}
		
	}
}
