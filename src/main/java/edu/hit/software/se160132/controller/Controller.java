package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.security.Role;
import org.apache.shiro.SecurityUtils;

import java.util.Optional;
import java.util.OptionalLong;

public interface Controller {
    default Optional<Long> getUid(){
        if(!SecurityUtils.getSubject().isAuthenticated()){
            return Optional.empty();
        }else{
            return Optional.of((Long)SecurityUtils.getSubject().getPrincipal());
        }
    }

    default boolean isAuthenticated(){
        return SecurityUtils.getSubject().isAuthenticated();
    }

    default boolean hasRole(Role role){
        return SecurityUtils.getSubject().hasRole(role.name());
    }
}
