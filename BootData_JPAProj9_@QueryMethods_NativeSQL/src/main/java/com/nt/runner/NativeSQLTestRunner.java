package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.view.ResultView1;
@Component
public class NativeSQLTestRunner implements CommandLineRunner {

	
	@Autowired
	private IMovieRepo repo;
	@Override
	public void run(String... args) throws Exception {    

		//int result=repo.registerMovie("Abhi", 7.5f,"2021");
	//System.out.println(result==0?"Movie not registered":"movie registered");
//=================================================
		System.out.println("++++++++++++");
		System.out.println("date and time is "+repo.fetchSysDate());

System.out.println("================================");
 int count=repo.createTempleTable();
System.out.println(count<0?"Table is not created":"table is created ");
 System.out.println(count);
 
	}//run

}//class
