package com.wallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;


@SpringBootApplication

public class WalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }
    @Bean
    CommandLineRunner runner (RepositoryUserData repositoryUserData, RepositoryTableTransaction repositoryTableTransaction) {
     return args -> {
        // klasa 1
         UserData userData = new UserData();
         userData.setUserId(1L);
         userData.setLogin("Misza");

         repositoryUserData.save(userData);
         System.out.println("ZAPISANO: User Misza!!");

         // klasa 2
         TableTransactions tableTransactions = new TableTransactions();
         tableTransactions.setTransId(213L);
         tableTransactions.setAmount(100L);
         tableTransactions.setData(LocalDateTime.now());
         tableTransactions.setAsset("SmartWallet");
         tableTransactions.setPrice(29321f);

         repositoryTableTransaction.save(tableTransactions);
         System.out.println("ZAPISANO: Tabele transakcji z datą: " + tableTransactions.getData() );

         UserData saved = repositoryUserData.findById(1L).orElseThrow(() -> new NoSuchElementException("Nie znaleziono Usera!!"));
         System.out.println("Potwierdzono odczyt usera" + saved.getLogin());
     };


    }
}
