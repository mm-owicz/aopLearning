package com.example.aopIntro;

import com.example.aopIntro.commons.aop.Example2Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy // enabling AspectJ
@ComponentScan
@Configuration
public class ApplicationConfig {

    public Example2Aspect myAspect(){
        Example2Aspect aspect = new Example2Aspect();
        // properties setting...
        return aspect;
    }

}
