package com.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//finder method for signin
	Optional<Employee> findByEmailAndPassword(String em, String pass);

	// derived finder method : date n dept
	List<Employee> findByJoinDateAfterAndDepartment(LocalDate date, String deptName);

	// custom query method : for getting complete name by sal
	@Query(value = "select new com.app.entities.Employee(firstName,lastName) from Employee e where e.salary between ?1 and ?2")
	// List<Employee> fetchEmpNamesBySalaryRange(double minSalary,double maxSalary);
	Stream<Employee> fetchEmpNamesBySalaryRange(double minSalary, double maxSalary);

	// Find all emps having lastname containing some keyword
	List<Employee> findByLastNameContaining(String key);

	// Apply salry increment to those emps from specific department , joined before
	// specific date : first via finder method
	List<Employee> findByDepartmentAndJoinDateBefore(String dept, LocalDate date);

	// Same requirement as above BUT using update JPQL
	@Modifying //For DML
	@Query("update Employee e set e.salary=e.salary+?1 where e.department=?2 and e.joinDate < ?3")
	int updateEmpSalary(double salIncr,String dept,LocalDate date);
}
