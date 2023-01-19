package task2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {

    @GetMapping("/textToUpperCase")
    public String sendToUpperCase(@RequestParam String text) {
        System.out.println("someone used method sendToUpperCase");
        return text.toUpperCase();
    }
}
