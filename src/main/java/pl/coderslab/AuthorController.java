package pl.coderslab;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author")
public class AuthorController {

   private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String hello() {
        Author author1 = new Author();
        author1.setFirstName("Jan");
        author1.setLastName("Kowalski");
        authorDao.save(author1);
        return "Hello world";
    }
}
