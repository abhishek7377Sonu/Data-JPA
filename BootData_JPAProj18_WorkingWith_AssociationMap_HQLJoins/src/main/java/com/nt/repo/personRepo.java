package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface personRepo extends JpaRepository<Person, Integer> {

	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.contactNumbers,ph.numberType,ph.provider from Person p inner join p.phonesinfo ph")
	@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.contactNumbers,ph.numberType,ph.provider from Person p outer join p.phonesinfo ph")
	public List<Object[]> getDataByJoins();
}
 