package com.beratyesbek.stockapp;

import com.beratyesbek.stockapp.model.entity.StockExchange;
import com.beratyesbek.stockapp.repository.StockExchangeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(StockExchangeRepository repository) throws Exception {
        return args -> {
           StockExchange stockExchange1 = StockExchange.builder()
                    .name("NASDAQ")
                    .description("American Stock Exchange")
                    .liveInMarket(true)
                    .build();
            StockExchange stockExchange2 = StockExchange.builder()
                    .name("BIST")
                    .description("Turkish Stock Exchange")
                    .liveInMarket(true)
                    .build();

            repository.save(stockExchange1);
            repository.save(stockExchange2);

        };
    }

}
