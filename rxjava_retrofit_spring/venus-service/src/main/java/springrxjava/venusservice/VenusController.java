package springrxjava.venusservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class VenusController {

    @GetMapping("/vlist")
    Mono<String> vlist() {
        List<String> numbers = Arrays.asList("One", "Two", "Three");
        return Mono.just("[1,2," + new Random().nextInt(numbers.size()+10) + "]");
    }

}
