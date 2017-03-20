package cn.bdqn.cms.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


public class MyBatisUtil {

	private static final Logger logger=Logger.getLogger(MyBatisUtil.class);
	//SqlSession工厂，用来创建Session对象
	private static SqlSessionFactory sessionFactory;

	static{
		try{
			//获得用来读取配置文件的输入流
			Reader reader=Resources.getResourceAsReader("mybatis.cfg.xml");
			//创建SqlSession工厂构建器
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//读取配置文件，创建SqlSession工厂
			sessionFactory=builder.build(reader);
		}catch(Exception ex){
			logger.error("创建SqlSessionFactory时发生错误",ex);
		}
	}
	
	public static SqlSession openSession(){
		//获取并返回SqlSession对象，默认不自动提交事务
		return sessionFactory.openSession();
	}

}
