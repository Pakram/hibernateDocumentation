package pokramovich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pokramovich.domain.pojo.Person;
import pokramovich.service.PersonService;

import java.util.List;

/**
 * Created by Pokramovich on 12.09.2016.
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public String showAllUsers(ModelMap model) {

        model.addAttribute("persons",personService.getAllPersons());
        return "person";
    }
}
