package com.example.revatureproject.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.revatureproject.entity.Accounts;
import com.example.revatureproject.entity.Posts;
import com.example.revatureproject.repository.AccountsRepository;

@Service
public class AccountsService {
    
    AccountsRepository accountsRepository;

    @Autowired
    public AccountsService(AccountsRepository accountsRepository){
        this.accountsRepository = accountsRepository;
    }

    public Accounts addAccount(Accounts account){
        if(account.getAccountPassword().length() < 4 || account.getUsername() == "" || findAccountByUsername(account) != null || account.getFirstName() == "" || account.getLastName() == ""){
            return null;
        }
        return accountsRepository.save(account);
    }

    public Accounts loginAccount(String username, String password){
        Optional<Accounts> optionalAccount = accountsRepository.findByUsernameAndAccountPassword(username, password);
        if(optionalAccount.isPresent()){
            Accounts successAccount = optionalAccount.get();
            return successAccount;
        }
        else{
            return null;
        }
    }

    public Accounts findAccountByUsername(Accounts account){
        Optional<Accounts> optionalAccount = accountsRepository.findByUsername(account.getUsername());
        if(optionalAccount.isPresent()){
            Accounts successAccount = optionalAccount.get();
            return successAccount;
        }
        else{
            return null;
        }
    }

    public Accounts updatePassword(int AccountId, String password){
        if(password.length() < 4){
            return null;
        }
        Optional<Accounts> optionalAccount = accountsRepository.findById(AccountId);
        if (optionalAccount.isPresent()){
            Accounts newAccount = optionalAccount.get();
            newAccount.setAccountPassword(password);
            return accountsRepository.save(newAccount);
        }
        else{
            return null;
        }
    }

    public Accounts updateEmail(int AccountId, String email){
        Optional<Accounts> optionalAccount = accountsRepository.findById(AccountId);
        if (optionalAccount.isPresent()){
            Accounts newAccount = optionalAccount.get();
            newAccount.setEmail(email);
            return accountsRepository.save(newAccount);
        }
        else{
            return null;
        }
    }

    public Accounts updatePhoneNumber(int AccountId, String phoneNumber){
        Optional<Accounts> optionalAccount = accountsRepository.findById(AccountId);
        if (optionalAccount.isPresent()){
            Accounts newAccount = optionalAccount.get();
            newAccount.setPhoneNumber(phoneNumber);
            return accountsRepository.save(newAccount);
        }
        else{
            return null;
        }
    }

    public List<Accounts> getAllAccounts(){
        return (List<Accounts>) accountsRepository.findAll();
    }

    public Accounts getAccountById(int AccountId){
        Optional<Accounts> optionalAccount = accountsRepository.findByAccountId(AccountId);
        if(optionalAccount.isPresent()){
            Accounts successAccount = optionalAccount.get();
            return successAccount;
        }
        else{
            return null;
        }
    }
}
