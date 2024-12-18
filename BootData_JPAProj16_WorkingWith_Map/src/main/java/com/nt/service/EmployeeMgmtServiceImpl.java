package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeInfo;
import com.nt.repo.EmployeeInfoRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
@Autowired
	private EmployeeInfoRepo repo;
	
	@Override
	public String registerEmployee(EmployeeInfo info) {
	
		return "Employee saved with "+repo.save(info).getEid()+"id value";
	}

}
