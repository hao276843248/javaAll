package cn.hao.student.service.student;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bdqn.mybatis.plugin.PageParam;
import cn.hao.student.entity.Student;
import cn.hao.student.mapper.StudentMapper;
import cn.hao.student.util.PageBean;
@Service("studentService")
public class StudentServiceImpl implements IStudentService{

	private StudentMapper studentMapper;
	

	@Autowired
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public Student getStudent(int id) {
		return studentMapper.getStudent(id);
	}

	@Override
	public PageBean findStudent(int pageIndex,int pageSize,String name) {
		
		if(StringUtils.isEmpty(name)){
			name=null;
		}
		
		PageParam p=new PageParam(pageIndex,pageSize);
		List<Student> result=studentMapper.findStudent(p, name);
		System.out.println(name+"+"+11111);
		PageBean pageBean=new PageBean();
		//×Ô¶¯·µ»ØpageCount£¬rowCount
		pageBean.setPageCount(p.getPageCount());
		pageBean.setRowCount(p.getRowCount());
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setResult(result);
		
		return pageBean;
	}

	@Override
	public void addStudent(Student student) {
		studentMapper.addStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentMapper.deleteStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		studentMapper.updateStudent(student);
	}

}
