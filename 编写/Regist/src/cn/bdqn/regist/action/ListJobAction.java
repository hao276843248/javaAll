package cn.bdqn.regist.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.bdqn.regist.entity.Job;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ListJobAction extends ActionSupport{
	
	
	@Override
	public String execute() throws Exception {
		List<Job> jobs=new ArrayList<Job>();
		jobs.add(new Job(1,"ѧ��"));
		jobs.add(new Job(2,"��ʦ"));
		jobs.add(new Job(3,"����Ա"));
		jobs.add(new Job(4,"ְԱ"));
		jobs.add(new Job(5,"����"));
		jobs.add(new Job(6,"����ְҵ��"));
		
		Map<String,Object> requestMap=(Map<String, Object>)ActionContext.getContext().get("request");
		requestMap.put("jobs",jobs);
		
		return NONE;
	}

}









