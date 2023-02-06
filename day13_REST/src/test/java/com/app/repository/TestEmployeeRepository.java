package com.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Employee;

@DataJpaTest // scan only DAO layer spring beans
//to Tell Spring boot container NOT to replace actual data source(DB) by the test data base
@AutoConfigureTestDatabase(replace = Replace.NONE)
//To disable rollback : 
@Rollback(false) // NOT recommended !!!!!!!!!!!
class TestEmployeeRepository {
	@Autowired
	private EmployeeRepository empRepo;

	@Test
	void test() {
		assertNotNull(empRepo);
	}

	@Test
	void testAddEmployees() {
		/*
		 * String firstName, String lastName, String email, String password, String
		 * department, // String location, LocalDate joinDate, double salary
		 */
		List<Employee> emps = List.of(
				new Employee("Rama", "Kher", "rama@gmail.com", "12345", "Rnd", "Pune", LocalDate.of(2020, 10, 20),
						45678),
				new Employee("Anish", "Kadam", "anish@gmail.com", "2345", "Finance", "Mumbai",
						LocalDate.of(2021, 11, 24), 65678),
				new Employee("Mihir", "Mujumdar", "mihir@gmail.com", "2346", "Rnd", "Mumbai", LocalDate.of(2021, 1, 2),
						25678),
				new Employee("Meera", "Patil", "meera@gmail.com", "2347", "Rnd", "Mumbai", LocalDate.of(2022, 11, 4),
						38678),
				new Employee("Riya", "Pathak", "riya@gmail.com", "2348", "Rnd", "Mumbai", LocalDate.of(2021, 10, 24),
						50678),
				new Employee("Shubham", "Agarwal", "shubham@gmail.com", "2349", "Rnd", "Mumbai",
						LocalDate.of(2021, 9, 21), 75678));
		empRepo.saveAll(emps);
	}

	// test : Find all emps having lastname containing some keyword
	@Test
	void testFindByLastNameContaining() {
		empRepo.findByLastNameContaining("mu").forEach(System.out::println);
	}

	// a test case for peek
	@Test
	void testPeek() {
	//	IntStream.rangeClosed(10, 20).peek(i -> System.out.println(i + 1)).forEach(System.out::println);
		//ArrayList<Employee> list=new ArrayList<>(null)
	}

}
