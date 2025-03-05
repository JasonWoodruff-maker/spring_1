package com.example.demo.cars;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.*;

@Configuration
public class carconfig {

    @Bean
    CommandLineRunner commandLineRunner(Carrepository carrepository){
        return args -> {
            Car zem = new Car(

                    "Ford",
                    "F150",
                    "red"
            );
            Car tim = new Car(

                    "Ford",
                    "F150",
                    "red"
            );

            carrepository.saveAll(
                    List.of(zem, tim)
            );

        };
    }
}
