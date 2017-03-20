package cn.bdqn.student.dao.student;

import cn.bdqn.student.entity.Student;
import cn.bdqn.student.util.PageBean;

public interface IStudentDAO {
	//���ѧ��
	public void addStudent(Student student);
	
	//����ѧ����ҳ�б�
	public PageBean findStudent(int pageIndex,int pageSize,String name,Integer courseId,Integer time,Integer educationId,Integer stat);

	//����ID��ȡѧ������
	public Student getStudent(Integer id);
	
	//����ѧ������
	public void updateStudent(Student student);
	
	//ɾ��ѧ������
	public void deleteStudent(Integer id);
	
}












