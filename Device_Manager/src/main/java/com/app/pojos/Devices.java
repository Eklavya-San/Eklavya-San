package com.app.pojos;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "devices")
@Getter
@Setter
@NoArgsConstructor
@ToString

//@AllArgsConstructor
public class Devices extends BaseEntity{
	
	@Column(name="Device_name",length = 20)
	private String name;
	@Column(name="Description",length = 100)
	private String Description;
	
	private LocalDate MfgDate;
	
	private Double price;

	public Devices(String name, String description, LocalDate mfgDate, Double price) {
		super();
		this.name = name;
		Description = description;
		MfgDate = mfgDate;
		this.price = price;
	}
	
}
