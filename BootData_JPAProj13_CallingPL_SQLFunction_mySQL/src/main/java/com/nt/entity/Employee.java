package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="EMP_PROFILE")
public class Employee {
	@Id
	@GeneratedValue //automatic generated value
	private Integer eno;
	private String ename;
	private String desg;
	private float salary;

}
