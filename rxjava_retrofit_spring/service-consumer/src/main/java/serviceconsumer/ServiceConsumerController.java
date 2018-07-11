package serviceconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class ServiceConsumerController {


    @GetMapping("/list")
    Mono<String> list() {
        List<String> greetings = Arrays.asList("One", "Two", "Three");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return Mono.just(greetings.get(randomNum));
    }

}
