package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.ElectronicDevice;

public interface DeviceServices {
	
	List<ElectronicDevice> getAllDevices();
	
	ElectronicDevice addNewDevice(ElectronicDevice transientDevice);
	
	String deleteDevice (Long id);
	
}
