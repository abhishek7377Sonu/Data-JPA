package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumbers;
import com.nt.repo.PhoneNumberRepo;
import com.nt.repo.personRepo;

@Service("otmService")
public class OneToManyMappingMgmtServiceImpl implements IOneToManyMappingMgmtService {

	@Autowired
	private personRepo personrepo;
	@Autowired
	private PhoneNumberRepo phonerepo;

	@Override
	public List<Object[]> fetchDataByJoins() {
		
		return personrepo.getDataByJoins();
	}
	
	
}//class