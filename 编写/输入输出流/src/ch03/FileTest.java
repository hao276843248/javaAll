package ch03;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file=new File("D:\\text.txt");
		System.out.println("是否存在"+file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.lastModified());
		System.out.println(file.length());
		
		File file2=new File("E:\\asd.exe");
		try {
			if(file2.createNewFile()){
				System.out.println("文件创建成功");
			}else{
				System.out.println("文件已存在");
			}
		} catch (IOException e) {
			System.out.println("创建文件是发生错误"+e.getMessage());
		}
		
		File file3=new File("E:\\exam");
		if(file3.mkdir()){
			System.out.println("目录创建成功");
		}else{
			System.out.println("目录创建失败");
		}
		
	
	}
}
