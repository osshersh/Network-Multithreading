package task3.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String s = getUrlContent("http://localhost:8082/sumNumbers?numbers=2&numbers=2&numbers=2");
        System.out.println(s);
    }

    public static String getUrlContent(String url) throws URISyntaxException, IOException, InterruptedException {
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(HttpRequest.newBuilder(new URI(url)).GET().build(), HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
