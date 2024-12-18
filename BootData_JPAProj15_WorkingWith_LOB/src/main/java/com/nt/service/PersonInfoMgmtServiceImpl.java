package com.nt.service;

import java.util.List;
import java.util.Optional;

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
public PersonInfo fetchPersonDetailsById(int pid) {
	Optional<PersonInfo>opt=repo.findById(pid);
	if(opt.isPresent())
		return opt.get();
	else
	return null;
}
	
	}


