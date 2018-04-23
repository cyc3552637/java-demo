package com.digital.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.digital.invocation.service.*;
import com.digital.invocation.service.impl.*;


//jdk方式，委托类必须实现接口，代理类只能对接口进行代理。
//使用java的反射机制，以及Proxy和InvocationHandler来实现，代理类与委托类实现了相同的接口。 
//UserInvocationHandler将代理类传入
//Proxy实行代理，被代理类被传入的代理类invocationHandler(userServiceimpl)代理，并且生产新的实例，实现动态代理。
//之后调用被被代理类的接口，实际上是在调用新生成的代理类
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserServiceImpl userServiceimpl = new UserServiceImpl();  
	        InvocationHandler invocationHandler = new UserInvocationHandler(userServiceimpl);  
	          
	        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(  
	        		userServiceimpl.getClass().getClassLoader(),   
	        		userServiceimpl.getClass().getInterfaces(),  
	                invocationHandler);  
	          
	        System.out.println(userServiceProxy.getName("jordan"));  
	        System.out.println(userServiceProxy.getAge());  
	}

}
