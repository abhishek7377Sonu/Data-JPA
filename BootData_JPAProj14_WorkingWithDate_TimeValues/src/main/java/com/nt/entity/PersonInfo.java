package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Person_Info")
public class PersonInfo {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private Float page;
	private LocalDate dob;
	private LocalTime tob;
	private LocalDateTime doj;

}
