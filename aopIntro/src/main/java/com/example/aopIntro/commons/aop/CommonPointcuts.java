package com.example.aopIntro.commons.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {
    // class with commonly used pointcuts

    // https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html

    /**
     * A join point is in the web layer if the method is defined
     * in a type in the com.xyz.web package or any sub-package
     * under that.
     */
    @Pointcut("within(com.example.aopIntro.web..*)")
    public void inWebLayer() {}

    /**
     * A join point is in the service layer if the method is defined
     * in a type in the com.xyz.service package or any sub-package
     * under that.
     */
    @Pointcut("within(com.example.aopIntro.service..*)")
    public void inServiceLayer() {}

    /**
     * A join point is in the data access layer if the method is defined
     * in a type in the com.xyz.dao package or any sub-package
     * under that.
     */
    @Pointcut("within(com.example.aopIntro.dao..*)")
    public void inDataAccessLayer() {}

    /**
     * A business service is the execution of any method defined on a service
     * interface. This definition assumes that interfaces are placed in the
     * "service" package, and that implementation types are in sub-packages.
     *
     * If you group service interfaces by functional area (for example,
     * in packages com.xyz.abc.service and com.xyz.def.service) then
     * the pointcut expression "execution(* com.xyz..service.*.*(..))"
     * could be used instead.
     *
     * Alternatively, you can write the expression using the 'bean'
     * PCD, like so "bean(*Service)". (This assumes that you have
     * named your Spring service beans in a consistent fashion.)
     */
    @Pointcut("execution(* com.example.aopIntro..service.*.*(..))")
//    @Pointcut("bean(*Service)")
    public void businessService() {}

    /**
     * A data access operation is the execution of any method defined on a
     * DAO interface. This definition assumes that interfaces are placed in the
     * "dao" package, and that implementation types are in sub-packages.
     */
    @Pointcut("execution(* com.example.aopIntro.dao.*.*(..))")
    public void dataAccessOperation() {}

    @Pointcut("execution(public * *(..))") // any public method
//    @Pointcut("execution(* set*(..))") // any method with a name that begins with set
//    @Pointcut("execution(* com.example.aopIntro.service.AccountService.*(..))") // any method defined by AccountService interface
//    @Pointcut("execution(* com.example.aopIntro.service.*.*(..))") // any method defined in service package
//    @Pointcut("execution(* com.example.aopIntro.service..*.*(..))\n") // any method defined in the service package or subpackages
//    @Pointcut("within(com.example.aopIntro.service.*)") // any join point in the service package
//    @Pointcut("within(com.example.aopIntro.service..*)") // as above, or subpackages
    public void example(){};
}
