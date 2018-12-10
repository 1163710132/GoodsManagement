package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.Account;
import edu.hit.software.se160132.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Account> register(String username, String password){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return Optional.of(accountRepository.save(account));
    }

    public String getUsernameById(Long id){
        return accountRepository.findById(id).map(Account::getUsername).orElse(null);
    }
}
