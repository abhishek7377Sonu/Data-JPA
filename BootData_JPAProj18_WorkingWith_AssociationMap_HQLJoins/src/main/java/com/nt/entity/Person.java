package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import org.springframework.stereotype.Service;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AM-PERSON_DETAILS")
@Setter
@Getter
public class Person implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1", initialValue = 1000, allocationSize = 1, sequenceName = "PID_SEQ1")
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)

	private Integer pid;
	@Column(length = 20)
	private String pname;
	@Column(length = 20)
	private String paddrs;
	@OneToMany(targetEntity = PhoneNumbers.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	//Cascade indiactes all non-select persistence operations performed on the parent object should be propagated to associated child object
	
	//Fetch indicates the parent obj should be normally but associated child 
	//       objects should loaded lazily on demand basis...
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Set<PhoneNumbers> phonesinfo;
public Person() {
	System.out.println("Person.Person():: 0-param constructor");
}
	@Override
	public String toString() {
		return "Person (parent) [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}

}
