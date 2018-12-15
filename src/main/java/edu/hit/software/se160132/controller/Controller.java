package edu.hit.software.se160132.controller;

import edu.hit.software.se160132.entity.EntityType;
import org.apache.shiro.SecurityUtils;

import java.util.Optional;

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

    default boolean hasRole(int role){
        return SecurityUtils.getSubject().hasRole(String.valueOf(role));
    }

    default Optional<Integer> getRole(Integer role) {
        if(SecurityUtils.getSubject().hasRole(String.valueOf(role))){
            return Optional.of(role);
        }else{
            return Optional.empty();
        }
    }
}
