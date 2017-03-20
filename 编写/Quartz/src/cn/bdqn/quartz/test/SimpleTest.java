package cn.bdqn.quartz.test;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import cn.bdqn.quartz.job.HelloJob;

public class SimpleTest {

	public static void main(String[] args)throws Exception {
		//1.创建JobDetail对象
		JobDetail jobDetail=new JobDetail("helloJob",HelloJob.class);

		//创建Trigger，在特定的时间点触发任务的执行
		SimpleTrigger trigger=new SimpleTrigger("simpleTrigger");
		//设置开始触发的时间
		trigger.setStartTime(new Date());
		//设置时间间隔
		trigger.setRepeatInterval(1000);		
		//设置重复执行的次数
		trigger.setRepeatCount(10);
		
		//创建调度器
		Scheduler sched=StdSchedulerFactory.getDefaultScheduler();
		//注册任务和触发器
		sched.scheduleJob(jobDetail,trigger);
		//开始调度
		sched.start();

	}
	
}






