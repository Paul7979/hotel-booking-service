package adp.resilience.gateway.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component(value = "roomService")
public class GatewayRoomService {
    private static final String SERVICE_NAME = "rooms";

    @CircuitBreaker(name = SERVICE_NAME)
    @Bulkhead(name = SERVICE_NAME)
    @Retry(name = SERVICE_NAME)
    public String getRooms() throws IOException, InterruptedException {
        double failureRate = 0.8f;
        double rand = Math.random();
        if (rand <= failureRate)
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/rooms"))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
