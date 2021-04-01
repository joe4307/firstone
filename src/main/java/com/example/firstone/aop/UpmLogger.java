package com.example.firstone.aop;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UpmLogger {

    LogCategory category();

    String operation();
}
