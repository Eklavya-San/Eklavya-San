package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.EmpSalIncrementRequest;
import com.app.dto.EmployeeResponse;
import com.app.dto.EmployeeSpecificResp;
import com.app.dto.LoginRequestDto;
import com.app.entities.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// dep : dao layer i/f
	@Autowired
	private EmployeeRepository empRepo;
	// dep : model mapper
	@Autowired
	private ModelMapper mapper;

	@PostConstruct
	public void init() {
		System.out.println("in init " + mapper);
	}

	@Override
	public List<Employee> getAllEmpDetails() {
		return empRepo.findAll();
	}

	@Override
	public Employee addEmpDetails(Employee transientEmp) {
		// TODO Auto-generated method stub
		return empRepo.save(transientEmp);
	}

	@Override
	public String deleteEmpDetails(Long empId) {
		// chekc if emp exists by id
		if (empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			return "Emp details deleted ....";
		}
		return "Deletion Failed : Invalid Emp Id !!!!!!!!!!!";
	}

	@Override
	public Employee fetchEmpDetails(Long empId) {
		// TODO Auto-generated method stub
		return empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID !!!!!"));
	}

	@Override
	public Employee updateEmpDetails(Employee detachedEmp) {
		// confirm if emp with id exists !
		if (empRepo.existsById(detachedEmp.getId())) {
			return empRepo.save(detachedEmp);
		}
		throw new ResourceNotFoundException("Invalid Emp Id : Updation Failed!!!!!!!!");
	}

	@Override
	public EmployeeSpecificResp authenticateEmp(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		Employee employee = empRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
		//=> success
		return mapper.map(employee, EmployeeSpecificResp.class);
		
	}

	@Override
	public List<Employee> getEmpsByDateAndDept(LocalDate joinDate1, String dept1) {
		// TODO Auto-generated method stub
		return empRepo.findByJoinDateAfterAndDepartment(joinDate1, dept1);
	}

	@Override
	public List<EmployeeResponse> getEmpsBySalary(double minSal, double maxSal) {

		// return empRepo.fetchEmpNamesBySalaryRange(minSal, maxSal);
		// OR simply send back List of DTO containing the properties , lifted from DB
		// Here a prog will have to do the conversion from Entity to DTO (later to be
		// done auto.)

//		return empRepo.fetchEmpNamesBySalaryRange(minSal, maxSal).//Stream<Emp>
//				map(e -> new EmployeeResponse(e.getFirstName(),e.getLastName())) //Stream<EmpResp>
//				.collect(Collectors.toList());
		return empRepo.fetchEmpNamesBySalaryRange(minSal, maxSal).// Stream<Emp>
				map(e -> mapper.map(e, EmployeeResponse.class)) // Entity --> DTO
				.collect(Collectors.toList());

	}

	@Override
	public List<Employee> getEmpsByLastNameContainingKey(String key) {
		// TODO Auto-generated method stub
		return empRepo.findByLastNameContaining(key);
	}

	@Override
	public String applySalaryIncrement(EmpSalIncrementRequest dto) {
//		empRepo.findByDepartmentAndJoinDateBefore(dto.getDept(), 
//				dto.getSpecifiedDate())
//				.forEach(e -> e.setSalary(e.getSalary() + dto.getSalIncrement()));
//		// OR using JPQL update
		int rows = empRepo.updateEmpSalary(dto.getSalIncrement(), dto.getDept(), dto.getSpecifiedDate());
		return "Applied sal increment to "+rows+" emps!";
		
	}

}
