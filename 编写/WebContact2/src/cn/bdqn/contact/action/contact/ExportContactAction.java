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
		//����excel������
		HSSFWorkbook book=new HSSFWorkbook();
		//����������
		HSSFSheet sheet=book.createSheet(user.getUserName()+"��ͨѶ¼");
		//������
		HSSFRow head=sheet.createRow(0);
		//�����ֶ�
		/*HSSFCell c1=head.createCell(0);
		c1.setCellValue("����");*/
		head.createCell(0).setCellValue("����");
		head.createCell(1).setCellValue("�Ա�");
		head.createCell(2).setCellValue("�绰");
		
		for(int i=0;i<contacts.size();i++){
			Contact contact=contacts.get(i);
			HSSFRow row=sheet.createRow(i+1);
			row.createCell(0).setCellValue(contact.getName());
			row.createCell(1).setCellValue(contact.getSex());
			row.createCell(2).setCellValue(contact.getPhone());			
		}
		//�����ֽ�������������ݴ����ֽ�����
		ByteArrayOutputStream os=new ByteArrayOutputStream();		
		book.write(os);
		//����ֽ�����
		byte[] data=os.toByteArray();
		//����������
		inputStream=new ByteArrayInputStream(data);
		fileName=URLEncoder.encode(user.getUserName()+"��ͨѶ¼.xls","UTF-8");
		return SUCCESS;
	}
	

}
