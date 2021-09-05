package com.commre_backend;

import com.commre_backend.data.Property;
import com.commre_backend.data.PropertyRepository;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class CommReBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommReBackendApplication.class, args);
    }


}
