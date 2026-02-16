package com.wallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

@SpringBootApplication

public class WalletApplication extends Application{
    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WalletApplication.class.getResource("/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("Smart Wallet - Twój Portfel");
        stage.setScene(scene);
        stage.show();
    }

    @Bean
    CommandLineRunner runner (RepositoryUserData repositoryUserData, RepositoryTableTransaction repositoryTableTransaction, RepositoryTableWallet repositoryTableWallet) {
     return args -> {
        // klasa 1
         UserData userData = new UserData();
         userData.setUserId(3L);
         userData.setLogin("NazwaTestowaLoginu");
         userData.setPesel(20260203L);
         userData.setPassword("TestZapisuHaseł");
         userData.setName("TestImienia");
         userData.setSurname("TestNazwiska");
         userData.setEmail("TestEmail");
         userData.setDayOfBirth("03.02.2026");
         userData.setCountry("TestZapisuKraju");
         userData.setPostCode(2026020320260203L);
         userData.setSupportMail("TestPomocniczegoMaila");
         userData.setPhoneNumber(202602032026L);

         repositoryUserData.save(userData);
         System.out.println("ZAPISANO: User " + userData.getUserId() + " " + userData.getLogin() );

         // klasa 2
         TableTransactions tableTransactions = new TableTransactions();
         tableTransactions.setTransId(213L);
         tableTransactions.setAmount(100L);
         tableTransactions.setData(LocalDateTime.now());
         tableTransactions.setAsset("GAZP.ME");
         tableTransactions.setPrice(29321f);

         repositoryTableTransaction.save(tableTransactions);
         System.out.println("ZAPISANO: Tabele transakcji z datą: " + tableTransactions.getData() );

         UserData saved = repositoryUserData.findById(userData.getUserId()).orElseThrow(() -> new NoSuchElementException("Nie znaleziono Usera!!"));
         System.out.println("Potwierdzono odczyt usera " + saved.getLogin());
         //Klasa 3

         TableWallet tableWallet = new TableWallet();
         tableWallet.setCurrency("TZW");
         tableWallet.setMoney(new BigDecimal(20260203));
         tableWallet.setDeposit(new BigDecimal(20260203));
         tableWallet.setWithdrawal(20260203f);

         repositoryTableWallet.save(tableWallet);

         System.out.println("Informacje o portfelu ID " + tableWallet.getWalletId() + " zostały wysłane" );
     };
    }
}
