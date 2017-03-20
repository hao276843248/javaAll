package cn.bdqn.quartz.test;

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.DateIntervalTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.DateIntervalTrigger.IntervalUnit;
import org.quartz.impl.StdSchedulerFactory;

import cn.bdqn.quartz.job.HelloJob;

public class CronTest {
	
	public static void main(String[] args) throws Exception{
		//1.����JobDetail����
		JobDetail jobDetail=new JobDetail("helloJob",HelloJob.class);

		//����Trigger�����ض���ʱ��㴥�������ִ��
		CronTrigger trigger=new CronTrigger();
		trigger.setName("testTrigger");
		trigger.setCronExpression("0/5 0 10-17 * * ?");
		
		//����������
		Scheduler sched=StdSchedulerFactory.getDefaultScheduler();
		//ע������ʹ�����
		sched.scheduleJob(jobDetail,trigger);
		//��ʼ����
		sched.start();
	}


}
