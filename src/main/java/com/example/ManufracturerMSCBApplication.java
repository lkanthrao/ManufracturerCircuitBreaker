package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "LB1", configuration = CustomLoadBalancerAlgorithm.class) //to enable load balancer
@EnableHypermediaSupport(type =HypermediaType.HAL)
@EnableFeignClients
@EnableHystrix
public class ManufracturerMSCBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufracturerMSCBApplication.class, args);
	}
}
