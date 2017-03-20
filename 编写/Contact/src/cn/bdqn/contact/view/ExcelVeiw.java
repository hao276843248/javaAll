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
		
		//从模型中取出要导出的数据
		List<Contact> contacts=(List<Contact>) model.get("contacts");
		User user=(User)session.getAttribute("user");

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
		
		//编码下载的文件名
		String fileName=URLEncoder.encode(user.getUserName()+"的通讯录.xls","UTF-8");
		//设置ContentDisposition响应头
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";filename*=utf-8''"+fileName);

	

	
	}

	
	
	
	
}
