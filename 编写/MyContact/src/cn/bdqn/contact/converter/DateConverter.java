package cn.bdqn.contact.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter{
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	
	@Override
	//���ַ���ת����Java����
	/*
	 * context:������ args:���ύ������,type:Ҫת����Ŀ������
	 * */
	public Object convertFromString(Map context, String[] args, Class type) {
		Timestamp ts=null;
		try {
			//���ԭʼ�������ַ���
			String dateStr=args[0];
			Date date=sdf.parse(dateStr);
			ts=new Timestamp(date.getTime());
		} catch (ParseException e) {
			throw new TypeConversionException(e);
		}
		return ts;
	}

	@Override
	//��Java����ת�����ַ���
	public String convertToString(Map context, Object object) {
		Timestamp ts=(Timestamp)object;
		return sdf.format(ts);
	}

}
