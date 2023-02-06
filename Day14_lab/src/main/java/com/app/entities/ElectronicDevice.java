package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="devices")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ElectronicDevice extends BaseEntities{
	
	@Column(length = 20,name="name")
	private String deviceName;
	@Column(length = 50,name="description")
	private String desc;
	@Column(name="price")
	private double price;
}
