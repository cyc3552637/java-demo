package com.digital.cglib;



import com.digital.cglib.service.UserService;
import com.digital.cglib.service.impl.UserServiceImpl;

import net.sf.cglib.proxy.Enhancer;

//cglib，code generate library，代理类可对类进行代理，使用第三方cglib库来实现。
//其内部使用asm框架生成代理类的字节码，其字节码文件更加复杂，不能代理final方法，因为代理类是委托类的子类。

public class Main {
	public static void main(String[] args) {  
        CglibMethodInterceptor cglibProxy = new CglibMethodInterceptor();  
  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(UserServiceImpl.class);  //传入带来类
        enhancer.setCallback(cglibProxy);  
  
        UserService o = (UserService) enhancer.create(); //传入被代理类  
        System.out.println(o.getName("baggio"));  
        System.out.println(o.getAge());  
    }  
}
//总的来说，反射机制在生成类的过程中比较高效，而asm在生成类之后的相关执行过程中比较高效（可以通过将asm生成的类进行缓存，这样解决asm生成类过程低效问题）