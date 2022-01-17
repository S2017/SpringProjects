package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")
public class DataAccessService implements PersonDao{
	
	private static List<Person> DB = new ArrayList<>();

	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		DB.add(new Person(id, person.getPersonName()));
		return 1;
	}

	@Override
	public List<Person> getAllPeople() {
		// TODO Auto-generated method stub		
		return DB;
	}

	@Override
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		Optional<Person> selectedPerson = selectPersonById(id);
		if(selectedPerson.isEmpty()) {
			return 0;
		}
		DB.remove(selectedPerson.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person update) {
		// TODO Auto-generated method stub
		return selectPersonById(id).map(p -> {
			int indexOfPersonToUpdate = DB.indexOf(p);
			if(indexOfPersonToUpdate >= 0) {
				DB.set(indexOfPersonToUpdate, new Person(id, update.getPersonName()));
				return 1;
			}
			return 0;
		})
		.orElse(null);
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream().
				filter(person -> person.getPersonId().equals(id))
						.findFirst();
	}

}
