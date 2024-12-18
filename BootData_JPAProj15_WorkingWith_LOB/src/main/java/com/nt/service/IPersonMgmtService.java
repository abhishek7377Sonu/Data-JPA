package com.nt.service;

import java.util.List;

import com.nt.entity.PersonInfo;

public interface IPersonMgmtService {

	
	public String registerPerson(PersonInfo info);
  public PersonInfo fetchPersonDetailsById(int pid);
}
