package edu.hit.software.se160132.service.impl;

import edu.hit.software.se160132.entity.Account;
import edu.hit.software.se160132.entity.Permission;
import edu.hit.software.se160132.repository.AccountRepository;
import edu.hit.software.se160132.repository.PermissionRepository;
import edu.hit.software.se160132.service.SecurityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityServiceImpl implements SecurityService {
    private final AccountRepository accountRepository;
    private final PermissionRepository permissionRepository;

    public SecurityServiceImpl(
            AccountRepository accountRepository,
            PermissionRepository permissionRepository) {
        this.accountRepository = accountRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Account createAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountRepository.save(account);
    }

    @Override
    public Permission grantPermission(Long grantor, Long accountId, Long target, Integer targetType) {
        Permission permission = new Permission();
        permission.setAccountId(accountId);
        permission.setCreator(grantor);
        permission.setTarget(target);
        permission.setTargetType(targetType);
        return permissionRepository.save(permission);
    }

    @Override
    public Optional<Account> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

}
