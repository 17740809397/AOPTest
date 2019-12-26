package com.htsc.carma.carma.myanotation;


import java.lang.annotation.*;

/**
 * ClassName Crmlog
 * AOP日志记录 自定义注解类
 * Date 2018年12月17日  14:27
 * @author DELL
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemCrmlog {
    /**
     * 日志描述
     * 对于什么表格进行了什么操作
     */
    String description()  default "";

    /**
     * 操作了的表名
     * @return
     */
    String  tableName() default "";
}
