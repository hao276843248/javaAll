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
		//1.创建JobDetail对象
		JobDetail jobDetail=new JobDetail("helloJob",HelloJob.class);

		//创建Trigger，在特定的时间点触发任务的执行
		CronTrigger trigger=new CronTrigger();
		trigger.setName("testTrigger");
		trigger.setCronExpression("0/5 0 10-17 * * ?");
		
		//创建调度器
		Scheduler sched=StdSchedulerFactory.getDefaultScheduler();
		//注册任务和触发器
		sched.scheduleJob(jobDetail,trigger);
		//开始调度
		sched.start();
	}


}
