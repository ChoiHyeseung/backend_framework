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
    public List<Engineer> exam2(int id ) {
        return engineerRepository.findByRoleId(id);}

    @RequestMapping(value = "/exam3", produces = "application/json; charset=utf8")
    public List<Engineer> exam3(String name) {
        return engineerRepository.findByNameStartsWithOrderByName(name);
    }

    @RequestMapping(value = "/exam4", produces = "application/json; charset=utf8")
    public List<Engineer> exam4(int id) {
        return engineerRepository.findByAssignmentProjectId(id);
    }

    @RequestMapping(value = "/exam5", produces = "application/json; charset=utf8")
    public List<Engineer> exam5(int id) {
        return engineerRepository.findByAssignmentProjectId(id);
    }


}

