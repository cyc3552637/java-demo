package com.digital.staticproxy;

import com.digital.staticproxy.service.impl.ProxyUserServiceImpl;
import com.digital.staticproxy.service.impl.RealUserServiceImpl;

//静态代理是典型的代理模式，通过接口特性，进行代理，动态代理是通过反射机制或者cglib实时代理
public class Main {
   public static void main(String[] args){
	   
	   ProxyUserServiceImpl proxy=new ProxyUserServiceImpl(new RealUserServiceImpl());
	   proxy.getName("baggio");
	   proxy.getAge();
	   
   }
}
