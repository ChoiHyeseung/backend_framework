package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Person;



public interface PersonRepository extends JpaRepository<Person, Integer>  {

}

