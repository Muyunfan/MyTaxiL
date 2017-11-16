package com.muyunfan.mytaxil.common.databus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类名称：RegisterBus
 * 类描述：自定义注解，用于标记观察者的方法
 * 创建人：L.C.W
 * 创建时间：on 2017/11/16 0016 14:37
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RegisterBus {
}
