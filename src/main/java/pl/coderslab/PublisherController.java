package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Helios");
        publisherDao.save(publisher);
        return "Hello world";
    }
    @RequestMapping("/test2")
    @ResponseBody
    public String removePublisher() {
        Publisher publisherId = publisherDao.findById(2);
        publisherDao.delete(publisherId);
        return "Remove publisher by Id";
    }

}
