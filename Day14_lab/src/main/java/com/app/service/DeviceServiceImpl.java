package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.DeviceException;
import com.app.entities.ElectronicDevice;
import com.app.repository.DeviceRepository;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceServices {
	
	@Autowired
	private DeviceRepository deviceRepo;

	@Override
	public List<ElectronicDevice> getAllDevices() {
		
		return deviceRepo.findAll();
	}

	@Override
	public ElectronicDevice addNewDevice(ElectronicDevice transientDevice) {
		
		return deviceRepo.save(transientDevice);
	}

	@Override
	public String deleteDevice(Long id) {
		if(deviceRepo.existsById(id)) {
			deviceRepo.deleteById(id);
			return "Successfully Deleted";
		}
		return "Deletion failed invalid id";
	}
	
	@Override
	public ElectronicDevice updateDeviceDetails(ElectronicDevice updated) {
		if(deviceRepo.existsById(updated.getId())) {
			return deviceRepo.save(updated);
		}
		throw new DeviceException("This is not valid emp id or emp not found");
	}
	
	@Override
	public ElectronicDevice fetchDetails (Long id) {
		return deviceRepo.findById(id).orElseThrow(()->new DeviceException("No such Device exist"));
	}



}
