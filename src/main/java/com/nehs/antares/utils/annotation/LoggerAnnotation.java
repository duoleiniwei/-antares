package com.nehs.antares.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1、@Target 表示该注解用于什么地方，可能的 ElemenetType 参数包括：
 * <p>
 * ElemenetType.CONSTRUCTOR   构造器声明
 * <p>
 * ElemenetType.FIELD   域声明（包括 enum 实例）
 * <p>
 * ElemenetType.LOCAL_VARIABLE   局部变量声明
 * <p>
 * ElemenetType.METHOD   方法声明
 * <p>
 * ElemenetType.PACKAGE   包声明
 * <p>
 * ElemenetType.PARAMETER   参数声明
 * <p>
 * ElemenetType.TYPE   类，接口（包括注解类型）或enum声明
 * <p>
 * 2、@Retention 表示在什么级别保存该注解信息。可选的 RetentionPolicy 参数包括：
 * <p>
 * RetentionPolicy.SOURCE   注解将被编译器丢弃
 * <p>
 * RetentionPolicy.CLASS   注解在class文件中可用，但会被VM丢弃
 * <p>
 * RetentionPolicy.RUNTIME   VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息。
 *
 * @author neHs
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerAnnotation {
    String value() default "";
}
