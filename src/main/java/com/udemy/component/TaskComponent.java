package com.udemy.component;

import java.util.Date;

import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskComponent")
public class TaskComponent {

	private static final org.apache.commons.logging.Log LOGGER = LogFactory.getLog(TaskComponent.class);
	//Utilizado para enviar correos electronicos de forma automatizada o tareas automatizadas!!! D;
//	@Scheduled(fixedDelay = 5000)
//	public void doTask() {
//		LOGGER.info("TIME IS: " +  new Date());
//	}
	
}
