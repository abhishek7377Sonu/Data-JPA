package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;


@Component
public class PL_SQLProcedureCallRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager; 

	@Override
	public void run(String... args) throws Exception {
		
		StoredProcedureQuery query=manager.createStoredProcedureQuery("PRO_AUTHENTICATION");
		//register param with java types
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3,String.class,ParameterMode.OUT);
		
		
		//set values in to IN params
		
		query.setParameter(1, "abhi");
		query.setParameter(2, "kisu");
		
		//call PL/SQL procedures
		String result=(String)query.getOutputParameterValue(3);
		System.out.println("Authentication result ::"+result);
		
		
		
	}// run

}// class
