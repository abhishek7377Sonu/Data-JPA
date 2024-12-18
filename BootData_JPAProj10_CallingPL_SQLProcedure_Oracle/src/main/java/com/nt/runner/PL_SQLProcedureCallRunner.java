package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import jakarta.persistence.CheckConstraint;
import com.nt.model.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Component
public class PL_SQLProcedureCallRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		// create stored procedure query object representing the given PL/SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_SECOND_MOVIE", Movie.class);
		// register parameters of PL/SQl procedure with JDBC types
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR);

		// call PL/SQL procedure
		query.setParameter(1, "2018");
		query.setParameter(2, "2024");

		// call PL/SQL PROCEDURE and get the results

		List<Movie> list = query.getResultList();
		list.forEach(System.out::println);

	}// run

}// class
