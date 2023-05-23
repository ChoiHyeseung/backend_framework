package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Category;
import net.skhu.entity.Person;
import net.skhu.repository.CategoryRepository;
import net.skhu.repository.PersonRepository;



@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired PersonRepository personRepository;
    @Autowired CategoryRepository categoryRepository;

    @RequestMapping("list")
    public String list(Model model) {
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "person/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        Person person = new Person();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("person", person);
        model.addAttribute("categories", categories);
        return "person/edit";
    }

    @PostMapping("create")
    public String create(Model model, Person person) {
        personRepository.save(person);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("pid") int pid) {
        Person person = personRepository.findById(pid).get();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("person", person);
        model.addAttribute("categories", categories);
        return "person/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Person person) {
        personRepository.save(person);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("pid") int pid) {
        personRepository.deleteById(pid);
        return "redirect:list";
    }
}

