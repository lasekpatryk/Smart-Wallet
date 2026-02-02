package com.wallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.NoSuchElementException;


@SpringBootApplication

public class WalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }
    @Bean
    CommandLineRunner runner (RepositoryUserData repositoryUserData) {
     return args -> {

         UserData userData = new UserData();
         userData.setUserId(1L);
         userData.setLogin("Misza");

         repositoryUserData.save(userData);
         System.out.println("ZAPISANO: User Misza!!");


         UserData saved = repositoryUserData.findById(1L).orElseThrow(() -> new NoSuchElementException("Nie znaleziono Usera!!"));
     };

    }
}
