package com.shuai.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 *
 * @author shuaion 2018/5/28
 **/
//@EnableAspectJAutoProxy 官网例子是单独一个bean来配置此注解
@Component
/**
 * 定义一个切面
 * 横切关注点(跨越应用程序多个模块的功能)被模块化的特殊对象／横切关注点的模块化/横切关注点集合
 */
@Aspect
public class MyAop {

    /**
     * 定义Pointcut，Pointcut名称为aspectjMethod,必须无参，无返回值
     * 只是一个标识，并不进行调用
     * 【需要拦截方法的表达式】
     */
    @Pointcut("execution(* com.shuai.service.impl.*.*(..))")
    public void pointCut(){}


    /**
     * 通知:切面必须要完成的工作（即切面里的每一个方法。如打印日志信息的方法）
     */
    @Before("pointCut()")
    public void methodBefore(){
        System.out.println("====here=is==methodBefore()====");
    }

    @After("within(com.shuai.service.impl.*)")
    public void methodAfter(){
        System.out.println("====here=is==methodAfter()====");
    }

    @AfterReturning(pointcut = "within(com.shuai.service.impl.*)",returning = "returnVal")
    public void methodAfterReturn(Object returnVal){
        System.out.println("====here=is==methodAfterReturn()==返回值=="+returnVal);
    }

    /**
     * 开启@Around @AfterReturning返回值取不到及@Before失效
     */
    //@Around("within(com.shuai.service.impl.*)")
    public void methodAround(){
        System.out.println("====here=is==methodAround()====");
    }

    @AfterThrowing(pointcut = "within(com.shuai.service.impl.*)",throwing = "ex")
    public void methodAfterThrowing(Exception ex){
        System.out.println("====here=is==methodAfterThrowing()===="+ex.getMessage());
    }

}
