package cn.hao.mybatis.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class Mybatis {

	private static final Logger logger=Logger.getLogger(Mybatis.class);
	//SqlSession��������������Session����
	private static SqlSessionFactory sessionFactory;

	static{
		try{
			//���������ȡ�����ļ���������
			Reader reader=Resources.getResourceAsReader("mybatis.cfg.xml");
			//����SqlSession����������
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			//��ȡ�����ļ�������SqlSession����
			sessionFactory=builder.build(reader);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("����SqlSessionFactoryʱ��������",ex);
		}
	}
	
	public static SqlSession openSession(){
		//��ȡ������SqlSession����Ĭ�ϲ��Զ��ύ����
		return sessionFactory.openSession();
	}
}
