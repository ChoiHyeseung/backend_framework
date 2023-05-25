package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Integer>  {

    @Override
	List<Engineer> findAll();
    List<Engineer> findById(int id);

//    List<Engineer> findByManagerId(int id);
    List<Engineer> findByRoleId(int roleId);
    List<Engineer> findByNameStartsWithOrderByName(String name);

    List<Engineer> findByAssignment_Project_id(int projectId);
    List<Engineer> findByAssignment_Project_Manager_id(int managerId);

}

