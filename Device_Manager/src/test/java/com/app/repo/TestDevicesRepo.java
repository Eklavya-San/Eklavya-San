package com.app.repo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.Devices;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class TestDevicesRepo {
	
	@Autowired
	private DeviceRepo devices;
	

	@Test
	void test() {
		assertNotNull(devices);
	}
	@Test
	void testAddDevices() {
		List<Devices> de= List.of(
				new Devices("Laptop", "Asus tuf A15", LocalDate.of(2020, 9, 20), (double)56000)
				);

		
		List<Devices> savedDevices = devices.saveAll(de);
		assertEquals(1,savedDevices.size());
		
	
	}

}
