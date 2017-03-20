package cn.hao.sx.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.bdqn.jdbc.DBHelper;
import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.sx.entity.Student;
import cn.hao.sx.entity.StudentFind;
import cn.hao.sx.entity.TJ;
import cn.hao.sx.util.MyBatisUtil;
import cn.hao.sx.util.PageBean;

public class StudentDAOImpl implements IStuinfoDAO{

	@Override
	public List<StudentFind> findStudent(TJ tj) {
		List<StudentFind> stFinds=null;
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			stFinds=session.selectList("stu.findStudent", tj);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
		return stFinds;
	}

	@Override
	public Student getStudent(int id) {
		Student s=null;
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			s=session.selectOne("stu.getStudent", id);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
		return s;
	}

	@Override
	public void delStudent(int id) {
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			session.delete("stu.delStudent",id);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
	}

	@Override
	public void addStudent(Student s) {
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			session.insert("stu.addStudent",s);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
	}

	@Override
	public void updateStudent(Student s) {
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行语句
			session.update("stu.upStudent",s);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}
	}

	
	@Override
	public List<StudentFind> findStudent(PageParam param, TJ tj) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
