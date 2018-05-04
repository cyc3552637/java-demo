#  内容  
  
annotate  
利用java反射机制自定义注解,包括field注解和方法注解,包括其调用  
  
staticproxy  
静态代理  
  
invocation  
通过Java反射机制实现动态代理  
  
cglib  
通过cglib实现动态代理  

动态代理一般委托了都是接口，代理类实现以后通过java反射机制或者cglib进行代理。  
这里有区别，cglib代理类可以是委托类的子类，用继承的方式代理，这样委托类不一定是接口了。  