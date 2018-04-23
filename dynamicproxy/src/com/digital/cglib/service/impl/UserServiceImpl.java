package com.digital.cglib.service.impl;

import com.digital.cglib.service.UserService;

public class UserServiceImpl implements UserService {  
    @Override  
    public String getName(String name) {  
        System.out.println("------getName------");  
        return name;  
    }  
  
    @Override  
    public Integer getAge() {  
        System.out.println("------getAge------");  
        return 10;  
    }  
} 
