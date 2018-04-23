package com.digital.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//cglib依赖的是cglib包下的methodInterceptor接口，每调用代理类的方法，都会调用intercept方法
//object为代理类，第一个参数obj一般指代理类，method是被代理的方法，执行proxy的时候就可以获得方法，args为该方法的参数数组。
//执行的时候，代理类实现的接口，会自动跟被代理方法相对应
public class CglibMethodInterceptor implements MethodInterceptor {  
    @Override  
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {  
        System.out.println("------before " + methodProxy.getSuperName() + "------");  
        Object o1 = methodProxy.invokeSuper(o, args);  
        System.out.println("------after " + methodProxy.getSuperName() + "------");  
        return o1;  
    }  
}  

