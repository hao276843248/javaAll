package cn.sun.tree.biz;

import cn.sun.tree.entity.Department;
import net.sf.json.JSONArray;

public interface DeptBiz {
	JSONArray getDept();
	
	Department getDepartmentById(int deptid);
	
	int addDept(Department department);
	
	int updateDept(Department department);
	
	int delDept(Department department);
	
	String getHtml();
	
	JSONArray getDeptByPid(int pid);
}
