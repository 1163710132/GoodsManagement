package edu.hit.software.se160132.security;

import edu.hit.software.se160132.entity.Account;
import edu.hit.software.se160132.entity.EntityType;
import edu.hit.software.se160132.entity.Permission;
import edu.hit.software.se160132.entity.RoleType;
import edu.hit.software.se160132.repository.AccountRepository;
import edu.hit.software.se160132.repository.PermissionRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component("accountRealm")
public class AccountRealm extends AuthorizingRealm {
    private AccountRepository accountRepository;
    private PermissionRepository permissionRepository;

    @Autowired
    public AccountRealm(AccountRepository accountRepository, PermissionRepository permissionRepository) {
        this.accountRepository = accountRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Long id = (Long) principals.getPrimaryPrincipal();
        authorizationInfo.addStringPermission(EntityType.ACCOUNT + ":" + id);
        Set<Integer> roles = new HashSet<>();
        permissionRepository.streamByAccountId(id).forEach(permission -> {
            authorizationInfo.addStringPermission(permission.getTargetType() + ":" + permission.getTarget());
            roles.add(permission.getTargetType());
        });
        authorizationInfo.addRoles(roles.stream().map(Object::toString).collect(Collectors.toList()));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        Account account = accountRepository
                .findFirstByUsername(username)
                .orElseThrow(UnknownAccountException::new);
        System.out.println("password:" +  account.getPassword());
        return new SimpleAuthenticationInfo(account.getId(), account.getPassword(), getName());
    }
}
