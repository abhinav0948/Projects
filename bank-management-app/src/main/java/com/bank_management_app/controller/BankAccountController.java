package com.bank_management_app.controller;

import com.bank_management_app.entity.BankAccount;
import com.bank_management_app.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {

    private BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount bankAccount) {
        BankAccount createdAccount = bankAccountService.createAccount(bankAccount);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<BankAccount> getAccountByAccountNumber(@PathVariable String accountNumber) {
        BankAccount account = bankAccountService.getAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllAccounts() {
        List<BankAccount> accounts = bankAccountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<BankAccount> deposit(@PathVariable String accountNumber, @RequestParam BigDecimal amount) {
        BankAccount account = bankAccountService.deposit(accountNumber, amount);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<BankAccount> withdraw(@PathVariable String accountNumber, @RequestParam BigDecimal amount) {
        BankAccount account = bankAccountService.withdraw(accountNumber, amount);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable String accountNumber) {
        bankAccountService.deleteAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok("Account with account number " + accountNumber + " deleted successfully");
    }

}
