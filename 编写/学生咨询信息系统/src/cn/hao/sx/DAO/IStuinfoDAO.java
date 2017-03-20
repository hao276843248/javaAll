package cn.hao.sx.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.sx.entity.Student;
import cn.hao.sx.entity.StudentFind;
import cn.hao.sx.entity.TJ;
import cn.hao.sx.util.PageBean;

public interface IStuinfoDAO {
	public List<StudentFind> findStudent(TJ tj);
	
	public Student getStudent(int id);
	
	public void delStudent(int id);
	
	public void addStudent(Student s);
	
	public void updateStudent(Student s);
	
	public List<StudentFind> findStudent(@Param("pageParam")PageParam param,
			@Param("tj")TJ tj);

}
