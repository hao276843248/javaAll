package cn.bdqn.contact.action.contact;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.User;

public class ExportContactAction extends BaseAction {
	private InputStream inputStream;
	private String fileName;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String execute() throws Exception {
		User user=(User)sessionMap.get(USER_SESSION_KEY);
		List<Contact> contacts=contactService.findContact(user.getId());
		//创建excel工作簿
		HSSFWorkbook book=new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet=book.createSheet(user.getUserName()+"的通讯录");
		//创建行
		HSSFRow head=sheet.createRow(0);
		//创建字段
		/*HSSFCell c1=head.createCell(0);
		c1.setCellValue("姓名");*/
		head.createCell(0).setCellValue("姓名");
		head.createCell(1).setCellValue("性别");
		head.createCell(2).setCellValue("电话");
		
		for(int i=0;i<contacts.size();i++){
			Contact contact=contacts.get(i);
			HSSFRow row=sheet.createRow(i+1);
			row.createCell(0).setCellValue(contact.getName());
			row.createCell(1).setCellValue(contact.getSex());
			row.createCell(2).setCellValue(contact.getPhone());			
		}
		//创建字节输出流，将数据存入字节数组
		ByteArrayOutputStream os=new ByteArrayOutputStream();		
		book.write(os);
		//获得字节数组
		byte[] data=os.toByteArray();
		//创建输入流
		inputStream=new ByteArrayInputStream(data);
		fileName=URLEncoder.encode(user.getUserName()+"的通讯录.xls","UTF-8");
		return SUCCESS;
	}
	

}
