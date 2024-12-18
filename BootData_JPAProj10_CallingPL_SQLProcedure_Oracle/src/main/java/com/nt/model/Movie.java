package com.nt.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data // Generating setter and getter methods
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SP_DATA_MOVIE")
//@DynamicInsert(true)
public class Movie implements Serializable {

	@Id
	@Column(name = "MID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid;
	@Column(name = "MNAME", length = 20)
	@NonNull
	private String mname;

	@Column(name = "YEAR", length = 20)
	@NonNull
	private String year;

//@Transient   //not store any value give null values
	@Column(name = "RATING")
	@NonNull
	private Float rating;

}
