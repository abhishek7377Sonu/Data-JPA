package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="EMPLOYEE_COLLECTION_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {
	@Id
	@GeneratedValue
	private Integer eid;
	
	@Column(length = 20)
	private String ename;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_FRIENDS",joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID"))
	@OrderColumn(name = "FRIEND_INDX")
	@ListIndexBase(value = 1)
	@Column(name="FRIEND_NAME", length = 20)
	@LazyCollection(LazyCollectionOption.FALSE)
	private  List<String> friends;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_PHONE_NUMBERS",
	                                                 joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID"))
	@Column(name="PHONE_NUMBER", length = 11)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Long>  phoneNumbers;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_ID_DETAILS",joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID"))
	@MapKeyColumn(name = "CARD_TYPE",length = 20)
	@Column(name="CARD_NUMBER",length = 20)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Map<String,String> idDetails;

}
