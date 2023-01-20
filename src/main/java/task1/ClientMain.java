package task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientMain {
    public static void main(String[] args) {
        String path = "src/main/resources/webPage.html";
        String url = "https://www.google.pl";
        saveWebPageByHTML(url, path);
    }

    public static void saveWebPageByHTML(String url, String path) {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request;
        HttpResponse response;
        try {
            request = HttpRequest.newBuilder(new URI(url)).GET().build();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            writer.write(response.body().toString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
