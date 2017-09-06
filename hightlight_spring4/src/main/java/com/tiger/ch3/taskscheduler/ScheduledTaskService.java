package com.tiger.ch3.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	@Scheduled(fixedRate=5000)
	public void reportCurrentTime(){
		System.out.println("每隔5秒执行一次"+sdf.format(new Date()));
	}
	@Scheduled(cron="0 28 21 ? * *")
	public void fixTimeExecution(){
		System.out.println("在指定时间 "+sdf.format(new Date())+" 执行任务");
	}
}
