package com.digital.staticproxy.service.impl;

import com.digital.staticproxy.service.UserService;

public class RealUserServiceImpl implements UserService {  
    @Override  
    public void getName(String name) {  
        System.out.println("------RealgetName------");  

    }  
  
    @Override  
    public void getAge() {  
        System.out.println("------RealgetAge------");  
 
    }  
} 
