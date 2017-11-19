package com.adamzurada.bus_routes_service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.adamzurada.bus_routes_service")
public class BusRoutesServiceApplicationTests {

    public static String TEST_RESOURCES_DIRECTORY = "src/test/resources/";
    public static String EXAMPLE_DATA_FILE_PATH = TEST_RESOURCES_DIRECTORY + "example/data";
    public static String HUGE_DATA_FILE_PATH = TEST_RESOURCES_DIRECTORY + "example/10000_rows";
    public static String ILLEGAL_CHARACTERS_DATA_FILE_PATH = TEST_RESOURCES_DIRECTORY + "example/illegal_characters";
    public static String NOT_EXISTING_FILE_PATH = TEST_RESOURCES_DIRECTORY + "example/not_existing";

    @Test
    public void contextLoads() {
    }

}
