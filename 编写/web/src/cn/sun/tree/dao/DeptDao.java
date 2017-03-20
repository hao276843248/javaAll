package cn.sun.tree.dao;

import java.util.List;

import cn.sun.tree.entity.Department;

public interface DeptDao {
	List<Department> getDepartments(int parentid);
	
	Department getDepartmentById(int deptid);
	
	int addDept(Department department);
	
	int updateDept(Department department);
	
	int delDept(Department department);
}
