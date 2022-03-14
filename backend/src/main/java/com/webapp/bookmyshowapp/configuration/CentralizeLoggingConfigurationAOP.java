package com.webapp.bookmyshowapp.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Component
public class CentralizeLoggingConfigurationAOP {

	/*
	 * Implementing Logging Using slf4j 
	 */
	Logger log = LoggerFactory.getLogger(CentralizeLoggingConfigurationAOP.class);
	
	/*To inform Spring AOP that this is our controller class or this is our service class where centralize logging should be
	 * implement, So there is annotation provided by SpringAOP which handles all these things that is : @PointCut
	 * 
	 * @PointCut : The role of pointCut will inform springAOP who will be my actual target and who is going to
	 * use this log statements or this piece of code(Logging mechanism) 
	 */
	
	/*
	 * Pointcut implementation 
	 * providing root directory to implement centralize logging accross the logging and i will use star(*) for any package, any class, any method 
	 * with any no. of arguments.
	 * The first * in execution block represent the any return type of method and the rest for in sequence package,class,method and then n no. of arguments
	 */
	@Pointcut("within(com.webapp.bookmyshowapp.controller.*) || within(com.webapp.bookmyshowapp.serviceimpl.*) || within(com.webapp.bookmyshowapp.util.*) || within(com.webapp.bookmyshowapp.repository.*) || within(com.webapp.bookmyshowapp.validations.*)")
	public void myPointCut() {
		//Here we will provide our pointcut as an expression so springAOP can understand that this is the path where this centralize logging will be implement
	}
	/*
	 * Proceeding Join using the reflection internally so it can dictate the method details what are the parameters coming to my 
	 * method. We can track this using this proceedingjoin point
	 * We are using @Around advice which is helpfull to track the full information like what inputs are giving to method and what
	 * response method is giving so there are are types of adive before advice and after advice
	 * BeforeAdvice - > what inputs are given to method 
	 * AfterAdvice - > what response is given by method
	 */
	@Around("myPointCut()")
	public Object ApplicationLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		
		/*
		 * To covert an array into json format
		 */
		ObjectMapper objectMapper = new ObjectMapper();
		
		/*
		 * To Get the current method name which is invoking now across the application
		 */
		String currentMethodName  =  proceedingJoinPoint.getSignature().getName();
		
		/*
		 * To Get the current class name which is used by current method across the application
		 */
		
		String currentClassName = proceedingJoinPoint.getTarget().getClass().toString();
		
		/*
		 * To Get the the inputs coming to the current method accross the application
		 * We will store in an array
		 */
		
		Object[] inputArray  = proceedingJoinPoint.getArgs();
		
		/*
		 * Log statement for accross the application
		 */
		/*try {*/
			/*
			 * All these given logs comes under the before advice
			 */
			objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			log.info("Entering into method : " + currentMethodName + "()");
			log.info("Method Invoked From -> " + currentClassName + " : " + currentMethodName + "()");
		/*} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("Error occured while executing centralized logging using objectMapper to convert inputString into json format for method : "  + currentClassName + " : " + currentMethodName + "()" , e);
			e.printStackTrace();
			throw e;
		}*/
		
		
		/*
		 * All these given logs comes under the after advice
		 */
		
		//To get the response from the currentmethod
		//Object currentMethodResponse  = null;
		/*try {*/
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			Object currentMethodResponse = proceedingJoinPoint.proceed();
			stopWatch.stop();
			log.info("Method Response From -> " + currentClassName + " : " + currentMethodName + "()" + "Execution Time : " + stopWatch.getTotalTimeSeconds());
			log.info("Exiting from method : " + currentMethodName + "()");
		/*} catch (Throwable e) {
			// TODO Auto-generated catch block
			log.error("Error occured in centralized logging during getting the response from current method : "  + currentClassName + " : " + currentMethodName + "()", e );
			e.printStackTrace();
			throw e;
		}*/
		
		
		return currentMethodResponse;
		
	}

}
