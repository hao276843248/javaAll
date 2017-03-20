package cn.hao.sx.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisUtil {
	private static final Logger logger=Logger.getLogger(MyBatisUtil.class);
	private static SqlSessionFactory sessionFactory;

	static{
		try{
			Reader reader=Resources.getResourceAsReader("mybatis.cfg.xml");
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			sessionFactory=builder.build(reader);
		}catch(Exception e){
            e.printStackTrace();
			logger.error("创建SqlSessionFactory时发生错误",e);
		}
	}
	public static SqlSession openSession(){
		return sessionFactory.openSession();
	}

}
