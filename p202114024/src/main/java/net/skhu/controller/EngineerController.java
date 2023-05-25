package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.entity.Engineer;
import net.skhu.repository.EngineerRepository;

@RestController
public class EngineerController {

    @Autowired EngineerRepository engineerRepository;


    @RequestMapping(value = "/exam1", produces = "application/json; charset=utf8")
    public List<Engineer> exam1() {
        return engineerRepository.findAll();
    }

    @RequestMapping(value = "/exam2", produces = "application/json; charset=utf8")
    public List<Engineer> exam2() {
        return engineerRepository.findByRoleId(1);}

    @RequestMapping(value = "/exam3", produces = "application/json; charset=utf8")
    public List<Engineer> exam3() {
        return engineerRepository.findByNameStartsWithOrderByName("이");
    }

    @RequestMapping(value = "/exam4", produces = "application/json; charset=utf8")
    public List<Engineer> exam4() {
        return engineerRepository.findByAssignment_Project_id(1);
    }

    @RequestMapping(value = "/exam5", produces = "application/json; charset=utf8")
    public List<Engineer> exam5() {
        return engineerRepository.findByAssignment_Project_Manager_id(2);
    }


}

