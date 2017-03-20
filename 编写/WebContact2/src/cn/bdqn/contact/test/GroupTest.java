package cn.bdqn.contact.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.contact.dao.group.GroupDAOImpl;
import cn.bdqn.contact.dao.group.IGroupDAO;
import cn.bdqn.contact.entity.Group;
import cn.bdqn.contact.service.group.IGroupService;


public class GroupTest {
	@Test
	public void testFindGroup(){
		ApplicationContext cxt =new ClassPathXmlApplicationContext("applicationContext.xml");
	IGroupService service=(IGroupService)cxt.getBean("groupService");
		
		//IGroupDAO dao =new GroupDAOImpl();
		List<Group> groups =service.findGroup();
		for(Group group :groups){
			System.out.println(group.getName());
		}
	}

}
