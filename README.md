# Aspect Oriented Programming

Key unit -> an Aspect
Cross-cutting concerns

tools: Spring AOP +/v AspectJ
- schema based approach (Spring AOP) v @ notation (AspectJ style)
Spring AOP:
- custom aspects
- declarative enterprise services
- only method interception
- used often with spring IoC

## AOP Concepts

**Aspect**
- modularization of a concern that cuts across multiple classes

**Join point**
- point during the execution of a program (method execution)

**Advice**
- action taken by an aspect at a particular join point
- around, before, after
- interceptor around the join point

__Advice types__
- Before - runs before join point, can't stop execution of join point (unless exception)
- After returning - after a join point completes normally
- After throwing - after join point throws an exception
- After finally - after join point, regardless if exception or not
- Around - before and after joint point, most powerful
best -> use least powerful method you eed
advice parameters -> use specific types, not Objects

**Pointcut**
- predicate that matches join points
- advice runs at any join point matched by the pointcut
- for example -> name of method

**Introduction**
- declaring additional methods or fields on behalf of a type
- for ex - make a bean implement an interface

**Target object**
- object being advised by aspects
- the advised object

**AOP proxy**
- obj created by the AOP framework to implement aspects functionalities
- in Spring -> JDK dynamic proxy

**Weaving**
- linking aspects with other application types sor objects to create an advised object
- Spring AOP -> runtime
- AspectJ compiler -> compile time

## Proxies
- standard -> JDK dynamic proxies
- can use CGLIB proxies to proxy classes and not interfaces

## Notes
./notes/AspectJ - aspectJ support
