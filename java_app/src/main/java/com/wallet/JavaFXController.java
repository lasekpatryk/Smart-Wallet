package com.wallet;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class JavaFXController {

    @FXML private TextField login;
    @FXML
    private Label statusLabel;

    @FXML
    protected void onHelloButtonClick() {
        statusLabel.setText("Saldo: 1,24 BTC - Pobrane z bazy!");
    }
}
