package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Devices;
import com.app.repo.DeviceRepo;


@Service
@Transactional
public class DeviceServicesImpl implements DeviceServices{
	@Autowired
	private DeviceRepo dRepo;

	@Override
	public List<Devices> getAllDevices() {
		
		return dRepo.findAll();
	}

	@Override
	public Devices AddDevice(Devices transientDevice) {
		// TODO Auto-generated method stub
		return dRepo.save(transientDevice);
	}

}
