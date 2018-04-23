package com.digital.annotate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.digital.annotate.service.UserService;
import com.digital.annotate.service.UserServiceMethod;
import com.digital.annotate.service.impl.UserServiceImpl;

public class Main{
public static void main(String[] args) throws Exception {  
	Class<UserServiceImpl> clazz = UserServiceImpl.class;  //注解实现类
    Method[] methods =  clazz.getMethods(); 
    Field[] fields = clazz.getDeclaredFields();
 
    for (Method method : methods) {                  //调用方法注解，方法注解着重实现方法功能
    	if (method.isAnnotationPresent(UserServiceMethod.class)) {
    		UserServiceMethod userservicemethod=method.getAnnotation(UserServiceMethod.class);
    		String parameter =userservicemethod.domethod();   //方法注解的parameter
    		System.out.println(parameter);
    		if(parameter.equals("method1")){                      
    		method.invoke(new UserServiceImpl(),"baggio",10);//调用方法注解的方法
    		 }
    		else if(parameter.equals("method2")) {           //方法注解的parameter
    			
    			method.invoke(new UserServiceImpl());       //调用方法注解的方法
    		}


    		
    	}
    }
    for (Field field : fields) {                     //调用field注解，feild注解着重实现变量赋值
        if(field.isAnnotationPresent(UserService.class)){
        	UserService userservicefield = field.getAnnotation(UserService.class);
            System.out.println("name："+userservicefield.name()); //feild注解的不同变量值
            System.out.println("age："+userservicefield.age());   //feild注解的不同变量值
        }
    }

    
      
  
}  
}