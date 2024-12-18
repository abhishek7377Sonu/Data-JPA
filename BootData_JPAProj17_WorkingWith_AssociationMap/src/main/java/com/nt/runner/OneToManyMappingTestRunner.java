package com.nt.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumbers;
import com.nt.service.IOneToManyMappingMgmtService;
@Component
public class OneToManyMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IOneToManyMappingMgmtService service;
	
	
	@Override
	public void run(String... args) throws Exception {
	
		/*
		//prepared child objects
		PhoneNumbers ph=new PhoneNumbers();
		ph.setContactNumbers(7894178752L);
		ph.setNumberType("Personal");ph.setProvider("airtel");
	PhoneNumbers ph1=new PhoneNumbers();
	ph1.setContactNumbers(9337129240L);
	ph.setNumberType("Residence");ph1.setProvider("Jio");
//prepare parent object
	Person per=new Person();
	per.setPname("abhishek");per.setPaddrs("odisha");
	per.setPhonesinfo(Set.of(ph,ph1));
	try {
		//invoke method
		System.out.println(service.saveDataUsingParent(per));
	}//try
	catch (Exception e) {
		e.printStackTrace();
	}//catch
	*/
		 
	//	service.loadDataUsingParent();
		//======================================================================
		
		//service.deleteParentAndItsChilds(1001);
		
		
		//====================================
		service.deleteAllphoneNumbersOfAPerson(1);
	}

}
