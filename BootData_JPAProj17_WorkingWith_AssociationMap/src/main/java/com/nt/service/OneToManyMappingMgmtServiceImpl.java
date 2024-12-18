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
	public String saveDataUsingParent(Person person) {

		return personrepo.save(person).getPid() + "Person is saved";
	}

	@Override
	public void loadDataUsingParent() {
		List<Person> list = personrepo.findAll();
		list.forEach(per -> {
			System.out.println("Parent::" + per);

			// get child of each parent
			Set<PhoneNumbers> childs = per.getPhonesinfo();
			childs.forEach(ph -> {
				System.out.println("child::" + ph);
			});
		});
	}// method

	@Override
	public String deleteParentAndItsChilds(int pid) {
		// Load parent object
		Optional<Person> opt = personrepo.findById(pid);
		// Here Along with Parent object the associated child objects will be loaded....
		if (opt.isPresent()) {
			personrepo.delete(opt.get());//if we delete parent object..the associated child object will be deleted
			return "person and his PhoneNumbers are deleted";
		} else {
			return "Person not found";
		}		
		
	}
	//Delete the  specific phone numbers
	@Override
	public String deleteAllphoneNumbersOfAPerson(int pid) {
		//load parent class 
		Optional<Person>opt=personrepo.findById(pid);
		if(opt.isPresent()) {
			//get childs of a parent
			Set<PhoneNumbers>childs=opt.get().getPhonesinfo();
		/*// approach 1
			childs.forEach(ph->{
			phonerepo.delete(ph);
		});
		*/
			//approach 2
			phonerepo.deleteAll(childs);
		return "All childs(PhoneNumbers) of a person are deleted";
		}
		else {
			return "person not found";
		}
	
	}
}// class
