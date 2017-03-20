package cn.sun.tree.action;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.sun.tree.biz.DeptBiz;
import cn.sun.tree.entity.Department;

public class DeptAction {
	private Department dept;
	private JSONArray result;
	private DeptBiz deptBiz;
	private JSONObject obj;

	public JSONObject getObj() {
		return obj;
	}

	public void setObj(JSONObject obj) {
		this.obj = obj;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	public void setDeptBiz(DeptBiz deptBiz) {
		this.deptBiz = deptBiz;
	}

	public String getNodes() {
		result = deptBiz.getDept();
		return "success";
	}

	public String getDeptById() {
		dept = deptBiz.getDepartmentById(dept.getDeptid());
		obj = JSONObject.fromObject(dept);
		return "success";
	}

	public String addDept() {
		int num = 0;
		num = deptBiz.addDept(dept);
		String mes = "";
		if (num > 0) {
			mes = "信息提交成功";
		} else {
			mes = "信息提交失败";
		}
		Map map = new HashMap();
		map.put("mes", mes);
		obj = JSONObject.fromObject(map);
		return "success";
	}

	public String updateDept() {
		int num = 0;
		num = deptBiz.updateDept(dept);
		String mes = "";
		if (num > 0) {
			mes = "信息修改成功";
		} else {
			mes = "信息修改失败";
		}
		Map map = new HashMap();
		map.put("mes", mes);
		obj = JSONObject.fromObject(map);
		return "success";
	}

	public String delDept() {
		int num = 0;
		num = deptBiz.delDept(dept);
		String mes = "";
		if (num > 0) {
			mes = "信息删除成功";
		} else {
			mes = "信息删除失败";
		}
		Map map = new HashMap();
		map.put("mes", mes);
		obj = JSONObject.fromObject(map);
		return "success";
	}

	public String getDeptByPid() {
		result = deptBiz.getDeptByPid(dept.getParentid());
		return "success";
	}
}
