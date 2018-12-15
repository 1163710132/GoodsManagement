package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.entity.Account;
import edu.hit.software.se160132.service.SecurityService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController implements Controller {
    private final SecurityService securityService;

    @Autowired
    public AccountController(SecurityService securityService) {
        this.securityService = securityService;
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
        return getUid().flatMap(securityService::findAccountById).map(Account::getUsername).orElse(null);
    }

    @RequestMapping("/uid")
    public Long uid(){
        return getUid().orElse(null);
    }

    @RequestMapping("/register")
    public Long register(String username, String password){
        try {
            Account account = securityService.createAccount(username, password);
            return account.getId();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
