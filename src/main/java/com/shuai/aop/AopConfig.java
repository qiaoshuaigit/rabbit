package com.shuai.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shuaion 2018/5/29
 *
 * 开启Aop功能 相当于 <aop:aspectj-autoproxy/>配置
 **/
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
}
