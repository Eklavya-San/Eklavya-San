package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.ElectronicDevice;
import com.app.repository.DeviceRepository;
import com.app.service.DeviceServices;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/devices")
public class DeviceController {
	
	@Autowired
	public DeviceServices drepo;
	
	public DeviceController() {
		System.out.println("inside device controller"+ getClass());
	}
	@GetMapping
	public List<ElectronicDevice>getAll (){
		return drepo.getAllDevices();
	}
	@PostMapping
	public ElectronicDevice addDevice(@RequestBody ElectronicDevice newDevice) { 
		return drepo.addNewDevice(newDevice);
	}
	@DeleteMapping("/{id}")
	
	public String  deleteDevice(@RequestBody Long id) {
		String message = drepo.deleteDevice(id);
		return message;
		
	}
	@PutMapping("update")
	public ElectronicDevice updateDevice (@RequestBody ElectronicDevice updated) {
		return drepo.updateDeviceDetails(updated);
	}
	
}
