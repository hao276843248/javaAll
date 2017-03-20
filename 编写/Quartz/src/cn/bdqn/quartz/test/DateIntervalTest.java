package cn.bdqn.quartz.test;

import java.util.Date;

import org.quartz.DateIntervalTrigger;
import org.quartz.DateIntervalTrigger.IntervalUnit;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import cn.bdqn.quartz.job.HelloJob;

public class DateIntervalTest {
	
	public static void main(String[] args) throws Exception{
		//1.����JobDetail����
		JobDetail jobDetail=new JobDetail("helloJob",HelloJob.class);

		//����Trigger�����ض���ʱ��㴥�������ִ��
		DateIntervalTrigger trigger=new DateIntervalTrigger();
		trigger.setName("testTrigger");
		//���ÿ�ʼ������ʱ��
		trigger.setStartTime(new Date());
		//����ʱ����
		trigger.setRepeatInterval(3);		
		//����ʱ������λ
		trigger.setRepeatIntervalUnit(IntervalUnit.SECOND);
		
		//����������
		Scheduler sched=StdSchedulerFactory.getDefaultScheduler();
		//ע������ʹ�����
		sched.scheduleJob(jobDetail,trigger);
		//��ʼ����
		sched.start();
	}

}
