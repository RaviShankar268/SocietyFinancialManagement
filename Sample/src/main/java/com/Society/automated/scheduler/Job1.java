package com.Society.automated.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.Society.automated.allwork.ConvetDao;

public class Job1 implements Job{
	
	final static Logger logger=LoggerFactory.getLogger(Job1.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ConvetDao cd=new ConvetDao();
		if(cd.mc())
		{
			logger.info("Job 1 done already");
		}
		else
		{
		cd.monthToyear();
		cd.copy();
		cd.setmc();
		cd.delete();
			logger.info("JOB 1 done and Temp table is clean");
		}
	}
	

}
