package com.nehs.antares.utils;

import com.nehs.antares.BaseController;
import com.nehs.antares.bo.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author neHs
 */
@Aspect
@Component
@Lazy(false)
@Slf4j
public class LoggerAspect extends BaseController {
    /**
     * 定义切入点：对要拦截的方法进行定义与限制，如包、类
     * <p>
     * 1、execution(public * *(..)) 任意的公共方法
     * 2、execution（* set*（..）） 以set开头的所有的方法
     * 3、execution（* com.lingyejun.annotation.logApply.*（..））com.lingyejun.annotation.logApply这个类里的所有的方法
     * 4、execution（* com.lingyejun.annotation.*.*（..））com.lingyejun.annotation包下的所有的类的所有的方法
     * 5、execution（* com.lingyejun.annotation..*.*（..））com.lingyejun.annotation包及子包下所有的类的所有的方法
     * 6、execution(* com.lingyejun.annotation..*.*(String,?,Long)) com.lingyejun.annotation包及子包下所有的类的有三个参数，第一个参数为String类型，第二个参数为任意类型，第三个参数为Long类型的方法
     * 7、execution(@annotation(com.lingyejun.annotation.Lingyejun))
     */
    @Pointcut("@annotation(com.nehs.antares.utils.annotation.LoggerAnnotation)")
    private void cutMethod() {

    }

    /**
     * 前置通知：在目标方法执行前调用
     */
    @Before("cutMethod()")
    public void before() {
        System.out.println("Aspect:@Before==cutMethod()");
    }

    /**
     * 后置通知：在目标方法执行后调用，若目标方法出现异常，则不执行
     */
    @AfterReturning("cutMethod()")
    public void afterReturning() {
        System.out.println("Aspect:@AfterReturning==cutMethod()");
    }

    /**
     * 后置/最终通知：无论目标方法在执行过程中出现一场都会在它之后调用
     */
    @After("cutMethod()")
    public void after() {
        System.out.println("Aspect:@After==cutMethod()");
    }

    /**
     * 异常通知：目标方法抛出异常时执行
     */
    @AfterThrowing("cutMethod()")
    public void afterThrowing() {
        System.out.println("Aspect:@AfterThrowing==cutMethod()");
    }

    /**
     * 环绕通知：灵活自由的在目标方法中切入代码
     */
    @Around("cutMethod()")
    public JsonResponse around(ProceedingJoinPoint joinPoint) throws Throwable {
//        //判断注解标识如果不为false则，进行登录
//        Class<?> aClass = joinPoint.getTarget().getClass(); //先获取被织入增强处理的目标对象，再获取目标类的clazz
//        String methodName = joinPoint.getSignature().getName(); //先获取目标方法的签名，再获取目标方法的名
//        log.info("methodName: " + methodName);  // 输出目标方法名
//        Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes(); //获取目标方法参数类型
//        Object[] args = joinPoint.getArgs();  //获取目标方法的入参
//        for (int i = 0; i < args.length; i++) {
//            log.info("argsName: " + args[i]); //输出目标方法的参数
//        }
//        Object proceed = null;
//        try {
//            Method method = aClass.getMethod(methodName, parameterTypes);  //获取目标方法
//            LoggerAnnotation annotation = method.getAnnotation(LoggerAnnotation.class);  //获取方法上的注解
//            annotation.value();  //获取注解函数值
//            long startTime = System.currentTimeMillis();
//            proceed = joinPoint.proceed();  //执行目标方法
//            long excTime = System.currentTimeMillis() - startTime;
//            log.info("执行时间：" + excTime + "毫秒");
//            log.info("proceed: " + proceed);  //打印目标方法的return结果
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
        Object proceed = joinPoint.proceed();
        return succeed(proceed);
    }
}
