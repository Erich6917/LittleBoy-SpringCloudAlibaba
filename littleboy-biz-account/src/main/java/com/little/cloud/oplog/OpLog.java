package com.little.cloud.oplog;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Comment
 * @Author LiYuan
 * @Date 2021-1-22
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface OpLog {

  String opModule() default ""; // 操作模块

  String opType() default "";  // 操作类型

  String opDesc() default "";  // 操作说明
}