# AspectJ

Style: regular Java classes annotated with annotations \
runtime: Spring AOP, not AspectJ compiler (in Spring projects)

## Enabling support

Spring does 'auto-proxying' beans. If a bean is advised by an aspect,
it generates a proxy for that bean to intercept methods.

library: 
`org.aspectj:aspectjweaver`

```java
@Configuration
@EnableAspectJAutoProxy // <----- !
public class ApplicationConfiguration {
}
```

## Declaring an Aspect

```java
@Aspect // Aspect
@Component  // bean
public class ExampleAspect {
}
```
Component - qualifies the aspect for autodetection of bean

or bean definition in config + class definition elsewhere:

```java
import com.example.aopIntro.commons.aop.ExampleAspect;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public ExampleAspect myAspect(){
        ExampleAspect exampleAspect = new ExampleAspect();
        // properties..
        return exampleAspect;
    }
}

@Aspect // Aspect
public class ExampleAspect {
}
```

Aspects can have methods and fields. Can have pointcut, advice, introduction declarations.
Can't be targets of advice from other aspects.

## Declaring a Pointcut

(predicate that matches join points eg. name of method) \
in Spring -> matching the execution of methods on Spring beans

two parts:
- name + parameters
- pointcut expression - which method? - regular method definition


Method name -> pointcut name. Must return void. \
Expression in () -> pointcut expression, what it matches.
```java
@Pointcut("execution(* transfer(..))") // the pointcut expression
private void anyOldTransfer() {} // the pointcut signature
```
in example: matches methods named `transfer`. Has name anyOldTransfer.

__Pointcut designators__
- execution - default, matching method execution points
- within - in a module for ex. com.xyz.service..*





