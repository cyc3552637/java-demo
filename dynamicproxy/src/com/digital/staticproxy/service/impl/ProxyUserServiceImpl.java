package com.digital.staticproxy.service.impl;

import com.digital.staticproxy.service.UserService;

public class ProxyUserServiceImpl {
	private UserService realuserserviceimpl;

    public ProxyUserServiceImpl(UserService realuserserviceimpl) {
        this.realuserserviceimpl = realuserserviceimpl;
    }
	
	   public void getName(String name) {  
	        System.out.println("------ProxygetName------"); 
	        realuserserviceimpl.getName(name);
	    }  
	  
	    public void getAge() {  
	        System.out.println("------ProxygetAge------"); 
	        realuserserviceimpl.getAge();
	    } 
}
