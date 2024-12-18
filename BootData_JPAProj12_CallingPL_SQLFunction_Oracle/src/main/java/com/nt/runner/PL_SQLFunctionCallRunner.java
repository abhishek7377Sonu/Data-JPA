package com.nt.runner;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.TypeConverterSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

/*
                         PL/SQL function queries
================================================================
create or replace FUNCTION FX_GET_MOVIE_BY_RATINGS_RANGE 
(
  STARTRATING IN NUMBER 
, ENDRATING IN NUMBER 
, CNT OUT NUMBER 
) RETURN SYS_REFCURSOR AS 
      DETAILS SYS_REFCURSOR;
BEGIN

SELECT COUNT(*) INTO CNT FROM SP_DATA_MOVIE;
        OPEN DETAILS FOR 
          SELECT MNAME,RATING,YEAR FROM SP_DATA_MOVIE WHERE RATING>=STARTRATING AND RATING<=ENDRATING;
  RETURN DETAILS;
END FX_GET_MOVIE_BY_RATINGS_RANGE;

*/
@Component
public class PL_SQLFunctionCallRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		// unwrap session object from EntityManager Object
		// unWrap means it is there inside object i bringing it...
		Session ses = manager.unwrap(Session.class);
		// Work with ReturningWork CallbackInterface based callback method..
		Object results[] = ses.doReturningWork(con -> {
			// write CallbackStatement based logic to call PL/SQL function
			CallableStatement cs = con.prepareCall("{?=call FX_GET_MOVIE_BY_RATINGS_RANGE(?,?,?)}");
			// register return(1) ,(4)out params with jdbc types
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.registerOutParameter(4, Types.INTEGER);
			// set values IN parameter
			cs.setFloat(2, 4.0f);
			cs.setFloat(3, 7.8f);
			// call PL/SQL function
			cs.execute();
			// gather results from output Parameters
			ResultSet rs = (ResultSet) cs.getObject(1);
			List<Object[]> list = new ArrayList<>();
			while (rs.next()) {
				Object record[] = new Object[3];
				record[0] = rs.getString(1);
				record[1] = rs.getString(2);
				record[2] = rs.getString(3); // corrected index
				list.add(record);
			} // while
			Object data[] = new Object[2];
			data[0] = list;
			data[1] = cs.getInt(4);
			return data;

		});

		List<Object[]> ratingsList = (List<Object[]>) results[0];
		ratingsList.forEach(md -> {
			for (Object val : md)
				System.out.print(val + " ");
			System.out.println();
		});
		// get count of records
		int count = (int) results[1];
		System.out.print("records count :: " +count);

	}// run
}// class