package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Person;

public interface personRepo extends JpaRepository<Person, Integer> {

}
