package edu.hit.software.se160132.service;

import edu.hit.software.se160132.entity.Account;
import edu.hit.software.se160132.entity.Permission;

import java.util.Optional;

public interface SecurityService {
    Account createAccount(String username, String password);
    Permission grantPermission(Long grantor, Long accountId, Long target, Integer targetType);
    Optional<Account> findAccountById(Long id);
}
