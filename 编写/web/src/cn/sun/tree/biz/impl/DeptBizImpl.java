package cn.sun.tree.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import cn.sun.tree.biz.DeptBiz;
import cn.sun.tree.dao.DeptDao;
import cn.sun.tree.entity.Department;
import cn.sun.tree.entity.TreeNode;

public class DeptBizImpl implements DeptBiz {
	@Autowired
	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	@Override
	
	public JSONArray getDept() {
		List<TreeNode> list=new ArrayList<TreeNode>();
		TreeNode tn=new TreeNode();
		tn.setId(0);
		tn.setText("组织结构");
		bindTree(tn, 0);
		list.add(tn);
		return JSONArray.fromObject(list);
	}
	
	public void bindTree(TreeNode node ,int pid) {
		List<Department> list=deptDao.getDepartments(pid);
		for (Department department : list) {
			TreeNode tn=new TreeNode();
			tn.setId(department.getDeptid());
			tn.setText(department.getDeptname());
			bindTree(tn,department.getDeptid());
			node.getChildren().add(tn);
		}
		
	}
	@Override
	public Department getDepartmentById(int deptid) {
		return deptDao.getDepartmentById(deptid);
	}
	@Override
	public int addDept(Department department) {
		// TODO Auto-generated method stub
		return deptDao.addDept(department);
	}
	@Override
	public int updateDept(Department department) {
		// TODO Auto-generated method stub
		return deptDao.updateDept(department);
	}
	@Override
	public int delDept(Department department) {
		// TODO Auto-generated method stub
		return deptDao.delDept(department);
	}
	@Override
	public String getHtml() {
		return null;
	}
	@Override
	public JSONArray getDeptByPid(int pid) {
		List<Department> list=deptDao.getDepartments(pid);
		
		return JSONArray.fromObject(list);
	}

}
