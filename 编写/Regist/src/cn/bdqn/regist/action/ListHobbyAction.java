package cn.bdqn.regist.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.bdqn.regist.entity.Hobby;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ListHobbyAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		List<Hobby> hobbies=new ArrayList<Hobby>();
		hobbies.add(new Hobby(1,"����"));
		hobbies.add(new Hobby(2,"�˶�"));
		hobbies.add(new Hobby(3,"��Ϸ"));
		hobbies.add(new Hobby(4,"����"));
		hobbies.add(new Hobby(5,"��Ӱ"));
		
		Map<String,Object> requestMap=(Map<String, Object>)ActionContext.getContext().get("request");
		requestMap.put("hobbies",hobbies);
		
		return NONE;
	}

}






