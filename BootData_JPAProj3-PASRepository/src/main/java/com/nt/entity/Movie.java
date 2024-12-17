package com.nt.entity;

import java.io.Serializable;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data //Generating setter and getter methods
@RequiredArgsConstructor
//@NoArgsConstructor

@Entity 
@Table(name="SP_DATA_MOVIE")

public class Movie implements Serializable {
	
	public Movie(String string, String string2, float f) {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="MID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private Integer mid;
	@Column(name="MNAME",length=20)
	@NonNull
	private String mname;
	@Column(name="YEAR",length=20)
	@NonNull
	private String year;
	@Column(name="RATING ") 
	@NonNull
	private float rating;
	
	
	

}
