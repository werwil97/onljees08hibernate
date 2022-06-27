package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String addPerson() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Maria");
        personDetails.setLastName("Jopek");
        personDetailsDao.save(personDetails);
        Person person = new Person();
        person.setLogin("mariaanaa");
        person.setPassword("jfiji65");
        person.setEmail("maria@.op");
        person.setPersonDetails(personDetails);
        personDao.save(person);
        return "addPerson";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String deletePerson() {
        Person person = personDao.findById(2);
        personDao.delete(person);
        return "deletePerson";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String updatePerson() {
        Person person = personDao.findById(2);
        PersonDetails person2 = person.getPersonDetails();
        person2.setLastName("Kowalska");
        personDetailsDao.update(person2);
        return "updatePerson";
    }


}
