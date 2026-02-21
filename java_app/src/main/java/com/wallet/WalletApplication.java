package com.wallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
public class WalletApplication extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init(){
        this.springContext = SpringApplication.run(WalletApplication.class);
}

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(WalletApplication.class.getResource("/main-view.fxml"));

        fxmlLoader.setControllerFactory(springContext::getBean);

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setTitle("FEHU - Smart Wallet");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        springContext.close();
    }

    public static void main (String[] args){
       launch(args);
    }

    @Bean
    CommandLineRunner runner(RepositoryUserData repositoryUserData, RepositoryTableTransaction repositoryTableTransaction, RepositoryTableWallet repositoryTableWallet) {
        return args -> {
            System.out.println("Spring działa w tle i zapisał dane!");
        };
    }
}
