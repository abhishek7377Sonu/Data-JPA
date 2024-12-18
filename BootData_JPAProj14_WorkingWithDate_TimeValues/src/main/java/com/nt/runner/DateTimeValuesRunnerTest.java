package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonMgmtService;

@Component
public class DateTimeValuesRunnerTest implements CommandLineRunner {

	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
 PersonInfo info = new PersonInfo(); //ctrl+1
info.setPname("Abhishek");
info.setPage(24.5f);
info.setDob(LocalDate.of(1999,8, 30));
info.setTob(LocalTime.of(3, 10, 50));
info.setDoj(LocalDateTime.of(2024,02,18,10,15));
System.out.println(service.registerPerson(info));
System.out.println("=======================");
service.fetchAllPersonDetails().forEach(System.out::println);
	}

}
