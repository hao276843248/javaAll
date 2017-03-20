package cn.bdqn.student.action.education;

import java.util.List;

import cn.bdqn.student.action.BaseAction;
import cn.bdqn.student.entity.Education;

public class ListEducationAction extends BaseAction{
	
	@Override
	public String execute() throws Exception {
		List<Education> educations=educationService.findEducation();
		requestMap.put("educations",educations);
		return NONE;
	}

}
