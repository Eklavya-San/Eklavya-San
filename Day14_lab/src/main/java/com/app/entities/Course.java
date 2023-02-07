package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.JoinColumnOrFormula;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="course")
//@Getter
//@Setter
@NoArgsConstructor
public class Course extends BaseEntity {
	@Column(name="course_name",length = 20,nullable = false)
	private String Cname;
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Student> std = new ArrayList<Student>() ;
	
	public void  AddStudent(Student newStd) {
		std.add(newStd);
		newStd.setCourse(this);
	}

	public Course(String cname) {
		super();
		Cname = cname;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	



}
