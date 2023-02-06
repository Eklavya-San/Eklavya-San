package com.app.service;

import java.util.List;

import com.app.pojos.Devices;

public interface DeviceServices {
	List<Devices>getAllDevices();
	Devices AddDevice(Devices transientDevice);
	

}
