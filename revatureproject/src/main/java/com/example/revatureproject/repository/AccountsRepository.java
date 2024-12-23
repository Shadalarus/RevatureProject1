package com.example.revatureproject.repository;
import com.example.revatureproject.entity.Accounts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    
    Optional<Accounts> findByUsernameAndAccountPassword(String Username, String AccountPassword);

    Optional<Accounts> findByUsername(String Username);

    Optional<Accounts> findByAccountId(Integer AccountId);
}
