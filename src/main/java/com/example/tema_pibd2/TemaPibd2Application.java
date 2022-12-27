package com.example.tema_pibd2;

import com.example.tema_pibd2.locations.Locations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class TemaPibd2Application {

    public static void main(String[] args) {
        SpringApplication.run(TemaPibd2Application.class, args);
    }

}
