package com.mobile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.beans.factory.BeanFactory;

import com.config.MyConfiguration;
//import com.sim.AirtelSim;
//import com.sim.IdeaSim;
//import com.sim.RelianceSim;
import com.sim.Sim;

public class RelianceMobile {
//	private Sim rs = new AirtelSim();
//	private Sim rs = new IdeaSim();
//	private Sim rs = new RelianceSim();
	
//	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//	private Sim r = context.getBean(Sim.class);
	
//	private Sim r1 = (Sim)context.getBean("sim1");
//	private Sim r2 = (Sim)context.getBean("sim2");
	
//	BeanFactory factory = new ClassPathXmlApplicationContext("spring.xml");
//	private Sim s = factory.getBean(Sim.class);
	
	ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
	private Sim s = context.getBean(Sim.class);
	public RelianceMobile() {
		startMobile();
		
//		r1.startSim();
//		r2.startSim();
		
		s.startSim();
	}
	public void startMobile() {
		System.out.println("Wel-come to Reliance Mobile");
	}
}
