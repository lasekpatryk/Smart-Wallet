// 1
package com.wallet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Entity
 class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userId;
    private String login;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String country;
    private String dayOfBirth;
    private String phoneNumber;
    private String pesel;
    private String postCode;
    private String supportMail;

    public UserData(String login, String name, String surname, String email, String country, String dayOfBirth, String phoneNumber, String pesel) {

        this.login = login;
        this.name = name;
        this.surname = surname;
//        this.password = password;
        this.email = email;
        this.country = country;
        this.dayOfBirth = dayOfBirth;
        this.phoneNumber = phoneNumber;
        this.pesel = pesel;
//        this.postCode = postCode;
//        this.supportMail = supportMail;

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSupportMail() {
        return supportMail;
    }

    public void setSupportMail(String supportMail) {
        this.supportMail = supportMail;
    }
}
@Repository
interface RepositoryUserData extends CrudRepository <UserData, Long> {

    UserData save(UserData userData);

    Optional<UserData> findById(Long id);

}