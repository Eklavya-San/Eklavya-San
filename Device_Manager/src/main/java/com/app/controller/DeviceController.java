package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Devices;

import com.app.service.DeviceServices;


@RestController
@RequestMapping("/devices")
@CrossOrigin(origins = "http://localhost:3000")
public class DeviceController {
	
	@Autowired
	private DeviceServices deviceService;
	
	public DeviceController() {
		System.out.println("inside the ctor");
	}
	
	@GetMapping
	public List<Devices>getDevices(){
		
		return deviceService.getAllDevices();
	}
	
	@PostMapping
	public Devices newDevice(@RequestBody Devices device) {
		
		return deviceService.AddDevice(device);
		
	}
	
	
}
