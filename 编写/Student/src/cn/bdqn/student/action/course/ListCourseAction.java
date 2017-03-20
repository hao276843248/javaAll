package cn.bdqn.student.action.course;

import java.util.List;

import cn.bdqn.student.action.BaseAction;
import cn.bdqn.student.entity.Course;

public class ListCourseAction extends BaseAction {
	
	@Override
	public String execute() throws Exception {
		List<Course> courses=courseService.findCourse();
		requestMap.put("courses",courses);
		return NONE;
	}

}
