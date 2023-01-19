package task4;

import java.util.List;

public class ThreadExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 6, 5);

        Thread thread1 = new Thread(() ->
                numbers.stream()
                        .reduce((accumulator, element) -> accumulator + element)
                        .stream().forEach(element -> System.out.println(element)));
        thread1.start();

        Thread thread2 = new Thread(() -> numbers
                .stream()
                .mapToInt(element -> element)
                .average().stream()
                .forEach(element -> System.out.println(element)));
        thread2.start();
    }
}
