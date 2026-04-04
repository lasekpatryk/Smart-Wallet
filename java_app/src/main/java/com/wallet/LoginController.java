package com.wallet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @Autowired
    private ApplicationContext springContext;


    @FXML
    private void welcomeHandleRegister(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/User-Registration.fxml"));

        fxmlLoader.setControllerFactory(springContext::getBean);

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("FEHU - Registration");
        stage.show();
    }

    @FXML private TextField login;
    @FXML private Label statusLabel;

    public void springContext(ConfigurableApplicationContext springContext) {
        this.springContext = springContext;
    }
}
