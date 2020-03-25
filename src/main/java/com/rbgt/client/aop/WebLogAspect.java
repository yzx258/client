package com.rbgt.client.aop;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.aop
 * @name: WebLogAspect
 * @author: Administrator
 * @date: 2020/1/28
 * @time: 16:29
 * @day_name_full: 星期二
 **/
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 切入点描述 这个是controller包的切入点
     */
    @Pointcut("execution(public * com.rbgt.client.controller..*.*(..))")
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称


    @Around("controllerLog()")
    public Object access(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        //获得请求的方法
        Method method = joinPointObject.getMethod();
        System.out.println("我是方法名："+method.getName());

//        if("createAuthenticationToken".equals(method.getName()))
//        {
//            return joinPoint.proceed();
//        }
//        String token = (String) getParams("token");
//        System.out.println("token ====================== " + token);
//        String tokenRabat = "123456";
//        if (token.equals(tokenRabat)) {
//            System.out.println("token is ok");
//        } else {
//            throw new BaseException(ResponseCode.NOT_PERMISSION);
//        }
        Object obj = joinPoint.proceed();
        return obj;
    }

    /**
     * 获取参数
     *
     * @param key
     * @return
     */
    private Object getParams(String key) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return request.getParameter(key);
    }

    /**
     * 在切入点的方法run之前要干的
     */
    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint) {
        //这个RequestContextHolder是Springmvc提供来获得请求的东西
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象
    }

    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE: {} " , ret);
        logger.info("SPEND TIME: {} ms", System.currentTimeMillis());
    }
}
