package cn.bdqn.contact.view;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.User;

public class ExcelVeiw extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model,
			HSSFWorkbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response
	) throws Exception {
		HttpSession session=request.getSession();
		
		//��ģ����ȡ��Ҫ����������
		List<Contact> contacts=(List<Contact>) model.get("contacts");
		User user=(User)session.getAttribute("user");

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
		
		//�������ص��ļ���
		String fileName=URLEncoder.encode(user.getUserName()+"��ͨѶ¼.xls","UTF-8");
		//����ContentDisposition��Ӧͷ
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";filename*=utf-8''"+fileName);

	

	
	}

	
	
	
	
}
