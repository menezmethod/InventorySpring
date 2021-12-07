package com.inventoryreact.InventoryReact.part;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PartConfig {

    @Bean
    CommandLineRunner commandLineRunner(PartRepository repository) {
        return args -> {
            Part kiwi = new Part(
                    "Kiwi",
                    10,
                    "inhouse",
                    "10.99",
                    100,
                    1000,
                    1223
            );
            Part banana = new Part(
                    "Banana",
                    10,
                    "outsourced",
                    "102.99",
                    100,
                    1000,
                    1223
            );
            repository.saveAll(
                    List.of(kiwi,banana)
            );
        };
    }
}
