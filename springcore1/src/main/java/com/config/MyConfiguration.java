package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sim.AirtelSim;
import com.sim.IdeaSim;
import com.sim.RelianceSim;
import com.sim.Sim;

@Configuration
public class MyConfiguration {
	@Bean
	public Sim obj() {
//		return new AirtelSim();
//		return new IdeaSim();
		return new RelianceSim();
	}
	
}
