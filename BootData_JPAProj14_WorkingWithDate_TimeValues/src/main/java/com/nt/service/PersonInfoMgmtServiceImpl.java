package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IPersonInfoRepo;
import com.nt.entity.PersonInfo;

@Service
public class PersonInfoMgmtServiceImpl implements IPersonMgmtService {
	@Autowired
	private IPersonInfoRepo repo;

	@Override
	public String registerPerson(PersonInfo info) {
   return repo.save(info).getPid()+"  person is saved";

	}

	@Override
	public List<PersonInfo> fetchAllPersonDetails() {
		
		return repo.findAll();
	}

}
