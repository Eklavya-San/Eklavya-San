package com.app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass

@Getter
@Setter
@ToString
public class BaseEntities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
}
