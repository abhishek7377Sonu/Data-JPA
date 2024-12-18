package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumbers;
 
public interface PhoneNumberRepo extends JpaRepository<PhoneNumbers, Integer> {

}
