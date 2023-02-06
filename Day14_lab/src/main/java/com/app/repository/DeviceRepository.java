package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ElectronicDevice;

public interface DeviceRepository extends JpaRepository<ElectronicDevice, Long>{

}
