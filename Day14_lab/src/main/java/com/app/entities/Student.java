package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.JoinColumnOrFormula;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
@NoArgsConstructor
public class Student extends BaseEntity {
	@Column(name="name", length = 30 , nullable = false,unique = true)
	private String fullName;
	@OneToOne
	@JoinColumn(name="course")
	private Course course;
	public Student(String fullName, Course course) {
		super();
		this.fullName = fullName;
		this.course = course;
	}
	

}
