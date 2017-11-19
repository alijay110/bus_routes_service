package com.adamzurada.bus_routes_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class BusRoutesServiceApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BusRoutesServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
        log.info("NonOptionArgs: {}", args.getNonOptionArgs());
        log.info("OptionNames: {}", args.getOptionNames());

        for (String name : args.getOptionNames()) {
            log.info("arg-" + name + "=" + args.getOptionValues(name));
        }

        boolean containsOption = args.containsOption("file.path");
        if (containsOption) {
            log.info("Using file.path provided in command-line argument for bus provider data");
        } else {
            log.info("Using default file.path for bus provider data defined in application properties.");
        }
    }
}
