package com.fkp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;

/**
 * 测试配置类@Configuration注解的proxyBeanMethods属性
 *      若为true此配置类为代理类，Spring会通过CgLib动态代理生成代理对象放入IOC容器，若为false则是普通对象
 *      若为代理对象，则调用@Bean注解的方法时会首先查找IOC容器中是否存在该bean的实例，若存在则直接返回，不存在则创建并加入IOC容器
 *      若为普通对象，则调用@Bean注解的方法都会重新创建该类型的对象，不会查找IOC容器，可以提高性能
 *      若被@Bean标注的方法之间存在依赖关系则使用ture,可以支持通过常规Java调用相同类的@Bean方法而保证是容器内的Bean，这有效规避了在“Lite模式”下操作时难以跟踪的细微错误，若使用false,则在创建user2Bean时调用的getUser不会从容器获取，而是普通创建，会导致getUser方法创建的User对象不在容器内，不受Spring管理，注解失效；若依然使用false，则可以将依赖的bean放到入参，Spring会自动将该bean匹配到入参
 *      若被@Bean标注的方法之间不存在依赖关系使用false，启动时不需要给配置类生成CGLIB子类，减少了启动时间；可以将配置类当作一个普通类使用：也就是说@Bean方法 可以是private、可以是final
 */
@Configuration(proxyBeanMethods = true)
public class TestConfiguration {

    @Bean(name = "user")
    public User getUser(){
        return new User();
    }

    @Bean(name = "user2")
    public User getUser2(){
        //若proxyBeanMethods为false则通过getUser()获取的User对象不在容器中，Spring注解会失效，可以通过将User放到入参中，此时Spring会将容器中的User对象传入
        User user = getUser();
        user.show();
        return user;
    }

    static class User{

        @Value("${common.swagger.basePackage}")
        private String basePackage;

        public User() {
            System.out.println("User的无参构造被调用");
        }
        public void show(){
            System.out.println(basePackage);
        }

    }
}
