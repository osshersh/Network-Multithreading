package task3.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/sumNumbers")
    public List<Integer> sendSumNumbers(@RequestParam List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Bad argument");
        }
        System.out.println("someone used method sendSumNumbers");
        return sumNumbers(numbers);
    }

    public List<Integer> sumNumbers(List<Integer> numbers) {
        return numbers.stream().reduce((accumulator, element) -> accumulator + element).stream().toList();
    }

}
