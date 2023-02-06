package com.app.entities;
/*
 * <tr key={employee.id}>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>{employee.workLocation}</td>
                <td>{employee.department}</td>
                <td>{employee.joinDate}</td>
                <td>{employee.salary}</td>
                <td>
 */

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//JPA annotations
@Entity
@Table(name="new_emps")
//Lombok annotations
@NoArgsConstructor //=def arg less ctor
@AllArgsConstructor //all args ctor
@Getter //all getters
@Setter //all setters
//@Data// all getters + setters + hashCode + equals + toString
@ToString(exclude = "password")//toString excluding password
//how to exclude null or blank(default) values during ser ?
//@JsonInclude(Include.NON_DEFAULT)
public class Employee extends BaseEntity {
	@Column(length = 20)
	@NotBlank(message = "First Name is required!!!!")
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 20,nullable = false)
	//How to tell Jackson (i.e a vendor for ser n deserial) to skip the property
	//from ser yet retain during de-ser ? 
	@JsonProperty(access = Access.WRITE_ONLY) // only setter will be accessible during conversion
	//Jackson uses : getters : during ser. n setters during de-ser.
	private String password;
	private String department;
	private String location;
	@Future(message = "join  date must be in future")
	private LocalDate joinDate;
	@Range(min = 20000,max=100000)
	private double salary;
	//add a propert to store image path
	@Column(length = 300)
	private String imagePath;
	//name based ctor
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee(@NotBlank(message = "First Name is required!!!!") String firstName, String lastName, String email,
			String password, String department, String location,
			@Future(message = "join  date must be in future") LocalDate joinDate,
			@Range(min = 20000, max = 100000) double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.department = department;
		this.location = location;
		this.joinDate = joinDate;
		this.salary = salary;
	}	
}
