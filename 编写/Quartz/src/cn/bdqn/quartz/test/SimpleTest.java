package cn.bdqn.quartz.test;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import cn.bdqn.quartz.job.HelloJob;

public class SimpleTest {

	public static void main(String[] args)throws Exception {
		//1.����JobDetail����
		JobDetail jobDetail=new JobDetail("helloJob",HelloJob.class);

		//����Trigger�����ض���ʱ��㴥�������ִ��
		SimpleTrigger trigger=new SimpleTrigger("simpleTrigger");
		//���ÿ�ʼ������ʱ��
		trigger.setStartTime(new Date());
		//����ʱ����
		trigger.setRepeatInterval(1000);		
		//�����ظ�ִ�еĴ���
		trigger.setRepeatCount(10);
		
		//����������
		Scheduler sched=StdSchedulerFactory.getDefaultScheduler();
		//ע������ʹ�����
		sched.scheduleJob(jobDetail,trigger);
		//��ʼ����
		sched.start();

	}
	
}






