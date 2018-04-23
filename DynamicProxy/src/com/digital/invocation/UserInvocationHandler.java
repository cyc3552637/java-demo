package com.digital.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//jdk的动态代理，依赖的是反射包下的invocationHandler接口，我们的代理类实现invocationHandler，重写invoke()方法，每当我们的代理类调用方法时，都会默认先经过invoke()方法。
//在实际使用时，第一个参数obj一般指代理类，method是被代理的方法，执行proxy的时候就可以获得方法，args为该方法的参数数组。
//执行的时候，代理类实现的接口，会自动跟被代理方法相对应
public class UserInvocationHandler implements InvocationHandler {  
    private Object target;  
  
    UserInvocationHandler() {  
        super();  
    }  
  
    UserInvocationHandler(Object target) {  
        super();  
        this.target = target;  
    }  
  
    @Override  
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {  
        if("getName".equals(method.getName())){  
            System.out.println("++++++before " + method.getName() + "++++++");  
            Object result = method.invoke(target, args);  
            System.out.println("++++++after " + method.getName() + "++++++");  
            return result;  
        }else {
        	System.out.println("++++++before " + method.getName() + "++++++"); 
            Object result = method.invoke(target, args);
            System.out.println("++++++after " + method.getName() + "++++++"); 
            return result;  
        }  
  
    }  
}  

