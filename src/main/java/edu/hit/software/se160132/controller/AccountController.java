package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.entity.Account;
import edu.hit.software.se160132.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController implements Controller {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/login")
    public Long login(String username, String password){
        try {
            System.out.println("received:" + password);
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));
            return (Long)SecurityUtils.getSubject().getPrincipal();
        }catch (AuthenticationException e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/username")
    public String username(){
        return getUid().map(accountService::getUsernameById).orElse(null);
    }

    @RequestMapping("/uid")
    public Long uid(){
        return getUid().orElse(null);
    }

    @RequestMapping("/register")
    public Long register(String username, String password){
        try {
            return accountService.register(username, password).map(Account::getId).orElse(null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
