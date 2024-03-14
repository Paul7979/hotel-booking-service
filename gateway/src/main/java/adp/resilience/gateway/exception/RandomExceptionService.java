package adp.resilience.gateway.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

public class RandomExceptionService {
  static Map<String, Throwable> exceptionPool = initializeExceptionPool();

  public static void throwRandomException(double failureRate) throws Throwable {
    var rand = Math.random();
    if (rand <= failureRate)
      throw getRandomException();
  }

  public static Throwable getRandomException() throws Throwable {
    var idx = (int) Math.floor(Math.random() * exceptionPool.size());
    var keys = exceptionPool.keySet().toArray();
    var key = keys[idx];
    throw exceptionPool.get(key);
  }

  public static Map<String, Throwable> initializeExceptionPool() {
    var exceptionPool = new HashMap<String, Throwable>();
    exceptionPool.put("BAD_REQUEST", new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Invalid input"));
    exceptionPool.put("INTERNAL_SERVER_ERROR",
        new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong with doing the request"));
    exceptionPool.put("IO_ERROR", new IOException());
    exceptionPool.put("ROOM_NOT_FOUND", new ResponseStatusException(NOT_FOUND, "No room with ID -1"));

    return exceptionPool;
  }
}
