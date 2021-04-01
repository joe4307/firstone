package com.example.firstone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@Aspect
public class AopTest {

    @Pointcut("@annotation(com.example.firstone.aop.UpmLogger)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        if (null == requestAttributes) {
            log.error("requestAttributes is null");
            throw new RuntimeException("requestAttributes is null");
        }
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        if (null == request) {
            log.error("request is null");
            throw new RuntimeException("request is null");
        }
        System.out.println("--------------------------"+request.getRequestURI());
        Object result = point.proceed();
        return result;
    }

}
