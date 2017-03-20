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
	//将字符串转换成Java对象
	/*
	 * context:上下文 args:表单提交的数据,type:要转换的目标类型
	 * */
	public Object convertFromString(Map context, String[] args, Class type) {
		Timestamp ts=null;
		try {
			//获得原始的日期字符串
			String dateStr=args[0];
			Date date=sdf.parse(dateStr);
			ts=new Timestamp(date.getTime());
		} catch (ParseException e) {
			throw new TypeConversionException(e);
		}
		return ts;
	}

	@Override
	//将Java对象转换成字符串
	public String convertToString(Map context, Object object) {
		Timestamp ts=(Timestamp)object;
		return sdf.format(ts);
	}

}
