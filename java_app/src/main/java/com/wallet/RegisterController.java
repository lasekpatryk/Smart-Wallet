package com.wallet;

import org.springframework.context.ApplicationContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.scene.control.TextField;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class RegisterController implements Initializable {

    @Autowired
    private ApplicationContext springContext;

    @FXML
    private void handleRegistrationClick(ActionEvent event){
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/User-Registration.fxml"));

            loader.setControllerFactory(springContext::getBean);

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("FEHU - Registration");
            stage.show();
        } catch (IOException e){
            System.out.println("BŁĄD: Nie znaleziono pliku User-Registration.fxml !");
            e.printStackTrace();
        }
    }

    @FXML
    private void backToMain (javafx.event.ActionEvent event) {

        try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/OknoPowitalne.fxml"));

        fxmlLoader.setControllerFactory(springContext::getBean);

        Parent root = fxmlLoader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("FEHU - Registration");
        stage.show();

        }catch (IOException e){
            System.out.println("BŁĄD: Nie znaleziono pliku OknoPowitalne.fxml !:");
            e.printStackTrace();
        }
    }

    @FXML
    private TextField nameLogin;
    private TextField nameFirstname;
    private TextField nameLastname;
    private TextField nameEmail;
    private TextField nameCountry;
    private TextField nameDayOfBirth;
    private TextField namePhone;
    private TextField namePesel;

    @FXML
    private void handleTextFieldAction(ActionEvent event){
        String login = nameLogin.getText();
        String name = nameFirstname.getText();
        String surname = nameLastname.getText();
        String email = nameEmail.getText();
        String country = nameCountry.getText();
        String dayOfBirth = nameDayOfBirth.getText();
        String phoneNumber = namePhone.getText();
        String pesel = namePesel.getText();

        UserData newUser = new UserData(login, name, surname, email, country, dayOfBirth, phoneNumber, pesel);
//        RepositoryUserData.save(newUser);

        System.out.println("Test tekst login: " + login);
        System.out.println("Test tekst imię: " + name);
        System.out.println("Test tekst nazwisko: " + surname);
        System.out.println("Test tekst email: " + email);
        System.out.println("Test tekst country: " + country);
        System.out.println("Test tekst urodziny: " + dayOfBirth);
        System.out.println("Test tekst phone: " + phoneNumber);
        System.out.println("Test tekst pesel: " + pesel);
    }

    @Override
    public void initialize (URL url,ResourceBundle resourceBundle){
        nameLogin.requestFocus();
        nameFirstname.requestFocus();
        nameLastname.requestFocus();
        nameDayOfBirth.requestFocus();
        namePhone.requestFocus();
        namePesel.requestFocus();

    }
 }