package com.digital.annotate.service;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//field注解，通过反射机制，输入匹配的注解参数，可以给参数赋值

@Retention(RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到  
@Target({METHOD,FIELD})//定义注解的作用目标**作用范围字段、枚举的常量/方法  
@Documented//说明该注解将被包含在javadoc中 
public @interface UserService {
	public String name() default "" ;  
	  
    public int age() default -1 ;
    
    String domethod() default "method1"; 
    
}
