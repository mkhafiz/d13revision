package sg.edu.nus.iss.d13revision.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.d13revision.models.Person;

@Service
public class PersonService {

    private List<Person> persons = new ArrayList<Person>();

    public PersonService() {

        persons.add(new Person("Mark", "Lee"));
        persons.add(new Person("Ali", "Baba"));
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void addPerson(Person p) {
        persons.add(new Person(p.getFirstName(), p.getLastName()));
    }

}
