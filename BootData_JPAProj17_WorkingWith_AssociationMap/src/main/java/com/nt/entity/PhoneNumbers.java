package com.nt.entity;
//child class
import java.io.Serializable;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AM_PHONENUMBERS_DETAILS")
@Setter
@Getter
public class PhoneNumbers implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer regNo;
@Column(length=20)
	private Long contactNumbers;
	@Column(length=20)
	private String numberType;
	@Column(length =20)
	private String provider;
	public PhoneNumbers() {
		System.out.println("PhoneNumbers():: 0-param constructor");
	}
	//taking property for foreign key(FK)  column any db table is optional
	@Override
	public String toString() {
		return "PhoneNumbers (child)  [regNo=" + regNo + ", phoneNumbers=" + contactNumbers + ", numberType=" + numberType
				+ ", provider=" + provider + "]";
		
		
	}
	
	
	
}
