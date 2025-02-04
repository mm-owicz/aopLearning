package com.example.aopIntro;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy // enabling AspectJ
@ComponentScan
@Configuration
public class ApplicationConfig {
}
