package uz.urunov.rediscashesample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RediscashesampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RediscashesampleApplication.class, args);
    }

}
