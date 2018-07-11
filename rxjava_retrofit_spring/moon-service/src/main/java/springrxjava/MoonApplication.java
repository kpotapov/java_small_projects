package springrxjava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@SpringBootApplication
public class MoonApplication {

    private static Logger log = LoggerFactory.getLogger(MoonApplication.class);

    @RequestMapping(value = "/list")
    public List<String> list() {
        log.info("/list was called");

        List<String> greetings = Arrays.asList("Archimedes crater", "Gagarin", "Gauss");
        return greetings;
    }

    public static void main(String[] args) {
        SpringApplication.run(MoonApplication.class, args);
    }
}