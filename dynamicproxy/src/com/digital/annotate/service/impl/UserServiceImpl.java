package com.digital.annotate.service.impl;

import com.digital.annotate.service.UserService;
import com.digital.annotate.service.UserServiceMethod;

public class UserServiceImpl {
	
//注解实施类，该类调用一次注解，将不同注解参数对应不同的方法和变量，先实行一遍。
//然后通过反射机制，别人调用注解的时候，就可以反射到我们这个实现类里，实际上调我们的实现类，实现了注解在不同参数下，会完成不同工作。
	
@UserService(name="pirlo")
private String name;

@UserService(age=10)
private int age;

@UserServiceMethod()  
public void method1(String name,int age) {  
	System.out.println("this is method1  "+name+"  age:"+age);
      
}  
@UserServiceMethod(domethod="method2") 
public void method2() { 
	System.out.println("this is method2");
      
}  
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}


}
