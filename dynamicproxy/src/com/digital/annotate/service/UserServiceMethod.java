package com.digital.annotate.service;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//方法注解，通过反射机制，输入匹配的注解参数，可以调用注解下面的执行方法
@Documented  
@Inherited  
@Retention(RUNTIME)  
@Target(METHOD) //次注解只能作用于方法上  
public @interface UserServiceMethod {  
  
    String domethod() default "method1";  
}  
