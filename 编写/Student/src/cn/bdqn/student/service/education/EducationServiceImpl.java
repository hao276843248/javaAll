package cn.bdqn.student.service.education;

import java.util.List;

import cn.bdqn.student.dao.education.EducationDAOImpl;
import cn.bdqn.student.dao.education.IEducationDAO;
import cn.bdqn.student.entity.Education;

public class EducationServiceImpl implements IEducationService{

	private IEducationDAO educationDAO=new EducationDAOImpl();
	
	@Override
	public List<Education> findEducation() {
		return educationDAO.findEducation();
	}
	
}
