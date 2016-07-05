/**
 * 
 */
package com.spring.integration.demo.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zoro02.lin
 *
 */
public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext-reconcile-virtual.xml");

		ReconcileGatewayService reconcileGatewayService = (ReconcileGatewayService) context.getBean("reconcileGatewayService");

		String result = reconcileGatewayService.check("VR", "20160629");

//		System.out.println(result);
		
//		context.start();
	}

}
