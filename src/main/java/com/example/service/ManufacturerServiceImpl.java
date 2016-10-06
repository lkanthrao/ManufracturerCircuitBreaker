package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;

import com.example.dao.ManufacturerFeignClient;
import com.example.model.Manufacturer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class ManufacturerServiceImpl implements ManufacturerService{

	
	@Autowired
	private ManufacturerFeignClient dao;
	
	@Override
	@HystrixCommand(fallbackMethod = "findAllFallback")
	public Resources<Manufacturer> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	public Resources<Manufacturer> findAllFallback(){
		return new Resources<Manufacturer>(){};
		
	}
	

}
