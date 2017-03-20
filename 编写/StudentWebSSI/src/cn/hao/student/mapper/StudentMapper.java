package cn.hao.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bdqn.mybatis.plugin.PageParam;

import cn.hao.student.entity.Student;

public interface StudentMapper {

	public Student getStudent(int id);
	
	public List<Student> findStudent(@Param("pageParam")PageParam pageParam,
			@Param("name")String name);
	
	public void addStudent(Student student);
	
	public void deleteStudent(int id);
	
	public void updateStudent(Student student);
}
