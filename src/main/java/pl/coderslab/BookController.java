package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookController(BookService bookService, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookService = bookService;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }




    @RequestMapping("/test")
    @ResponseBody
    public String hello2() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        bookService.save(book);
        book.setTitle("Thinking in Javaaa");
        bookService.update(book);
        return "Hello world";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);
        Book book = new Book();
        book.setTitle("Java 2 podstawy");
        book.setRating(5);
        book.setPublisher(publisher);
        bookService.save(book);
        return "Add";
    }

    @RequestMapping("/addAuthor")
    @ResponseBody
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("J.K");
        author.setLastName("Rowling");
        authorDao.save(author);
        Author author2 = new Author();
        author.setFirstName("Julian");
        author.setLastName("Tuwim");
        authorDao.save(author2);
        Book book = new Book();
        book.setTitle("Java");
        book.setRating(5);
        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(1));
        authors.add(authorDao.findById(2));
        book.setAuthor(authors);
        bookService.save(book);
        return "AddAuthor";
    }

}
