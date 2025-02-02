package com.bank_management_app.service;

import com.bank_management_app.entity.BankAccount;
import com.bank_management_app.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    public BankAccount createAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount getAccountByAccountNumber(String accountNumber) {
        return bankAccountRepository.findByAccountNumber(accountNumber);
    }

    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount deposit(String accountNumber, BigDecimal amount) {
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance().add(amount));
            return bankAccountRepository.save(account);
        }
        return null;
    }

    public BankAccount withdraw(String accountNumber, BigDecimal amount) {
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (account != null && account.getBalance().compareTo(amount) >= 0) {
            account.setBalance(account.getBalance().subtract(amount));
            return bankAccountRepository.save(account);
        }
        return null;
    }

    public void deleteAccountByAccountNumber(String accountNumber) {
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            bankAccountRepository.deleteByAccountNumber(accountNumber); // Delete the account
        } else {
            throw new RuntimeException("Account not found with account number: " + accountNumber);
        }
    }

}