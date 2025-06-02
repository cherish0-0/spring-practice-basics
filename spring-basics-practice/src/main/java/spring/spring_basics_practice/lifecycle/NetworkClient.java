package spring.spring_basics_practice.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class NetworkClient {

    private String url;

    // Constructor - called when the object is created
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    public void disconnect() {
        System.out.println("close: " + url);
    }

    // Lifecycle callback - executed after dependency injection is complete
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("message of init");
    }

    // Lifecycle callback - executed before the bean is destroyed
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
