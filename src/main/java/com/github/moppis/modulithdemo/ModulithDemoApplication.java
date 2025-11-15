package com.github.moppis.modulithdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class ModulithDemoApplication {
    static void main(String[] args) {
        SpringApplication.run(ModulithDemoApplication.class, args);

        ApplicationModules.of(ModulithDemoApplication.class).forEach(System.out::println);
    }
}
