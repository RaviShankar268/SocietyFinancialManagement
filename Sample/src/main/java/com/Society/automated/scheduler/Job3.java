package com.Society.automated.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.automated.allwork.LateDao;

public class Job3 implements Job{
	
	final static Logger logger=LoggerFactory.getLogger(Job3.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LateDao ld=new LateDao();
		if(ld.ul())
		{
			logger.info("LATE FEES UPDATED EARLIER");
		}
		else
		{
		ld.updateLate();
		ld.insertul();
			logger.info("LATE FEES UPDATED");
		}
	}

}
