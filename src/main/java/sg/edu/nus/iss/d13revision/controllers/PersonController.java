package sg.edu.nus.iss.d13revision.controllers;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.d13revision.models.Person;
import sg.edu.nus.iss.d13revision.services.PersonService;

@Controller
public class PersonController {

    private List<Person> personList = new ArrayList<Person>();

    @Autowired
    PersonService perSvc; // not needed to create '=new PersonService' bcos of Autowired

    @Value("${welcome.message}") // Injection - taking from app.properties
    private String message;

    @Value("${error.message}") // Injection - taking from app.properties
    private String errorMessage;

    // Request mapping is an umbrella for all methods, when written
    // 'RequestMethod.GET' = it knows its a GET methods
    @RequestMapping(value = { "/", "/home", "/index" }, method = RequestMethod.GET) // url name (3 options)
    public String index(Model model) { // Welcome message
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = "/testRetrieve", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Person> getAllPersons() {
        personList = perSvc.getPersons();
        return personList;

    }

    @RequestMapping(value = "/personList", method = RequestMethod.GET) // path || value
    public String personList(Model model) { // Model needed for injecting into html based on th
        personList = perSvc.getPersons();
        model.addAttribute("persons", personList);

        return "personList";
    }
}