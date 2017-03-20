package cn.bdqn.student.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.bdqn.student.service.course.CourseServiceImpl;

import cn.bdqn.student.service.course.ICourseService;
import cn.bdqn.student.service.education.EducationServiceImpl;
import cn.bdqn.student.service.education.IEducationService;
import cn.bdqn.student.service.student.IStudentService;
import cn.bdqn.student.service.student.StudentServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware{
	
	protected ICourseService courseService=new CourseServiceImpl();
	protected IEducationService educationService=new EducationServiceImpl();
	protected IStudentService studentService=new StudentServiceImpl();
	
	
	protected Map<String, Object> requestMap;
	
	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap=requestMap;
	}

}
