package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Devices;

public interface DeviceRepo extends JpaRepository<Devices, Long> {

}
