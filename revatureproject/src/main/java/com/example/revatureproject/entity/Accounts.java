package com.example.revatureproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name="accounts")
public class Accounts {
    
    @Column(name="account_id")
    @Id
    @GeneratedValue
    private Integer accountId;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="username")
    private String username;
    
    @Column(name="account_password")
    private String accountPassword;

    public Accounts(){

    }

    public Accounts(String firstName, String lastName, String email, String username, String accountPassword){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.accountPassword = accountPassword;
    }

    public Accounts(Integer accountId, String firstName, String lastName, String email, String phoneNumber, String username, String accountPassword){
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.accountPassword = accountPassword;
    }

    public Integer getAccountId(){
        return accountId;
    }
    public void setAccountId(Integer accountId){
        this.accountId = accountId;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getAccountPassword(){
        return accountPassword;
    }
    public void setAccountPassword(String accountPassword){
        this.accountPassword = accountPassword;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Accounts other = (Accounts) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;

        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;

        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;

        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;

        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;

        if (accountPassword == null) {
            if (other.accountPassword != null)
                return false;
        } else if (!accountPassword.equals(other.accountPassword))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                '}';
    }       
}
