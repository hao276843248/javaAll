package cn.bdqn.student.service.course;

import java.util.List;

import cn.bdqn.student.dao.course.CourseDAOImpl;
import cn.bdqn.student.dao.course.ICourseDAO;
import cn.bdqn.student.entity.Course;

public class CourseServiceImpl implements ICourseService {
	
	private ICourseDAO courseDAO=new CourseDAOImpl();
	
	@Override
	public List<Course> findCourse() {
		return courseDAO.findCourse();
	}

}
