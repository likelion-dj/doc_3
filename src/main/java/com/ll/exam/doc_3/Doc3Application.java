package com.ll.exam.doc_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Doc3Application {
    public static void main(String[] args) {
        SpringApplication.run(Doc3Application.class, args);
    }

}
