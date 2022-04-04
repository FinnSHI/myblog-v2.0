package com.finn.blog.annotation;

import java.lang.annotation.*;

/*
 * @description: 操作日志注解
 * @author: Finn
 * @create: 2022/04/04 21:15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {

    /**
     * @return 操作类型
     */
    String optType() default "";

}
