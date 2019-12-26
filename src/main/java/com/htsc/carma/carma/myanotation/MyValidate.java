package com.htsc.carma.carma.myanotation;

import java.lang.reflect.Field;

/**
 * @author DELL
 */
public class MyValidate {

    public static<T> void  validator(T t)throws Exception{
        StringBuilder builder=new StringBuilder();
        Class<?> aClass = t.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            CjlNotNull annotation = declaredField.getAnnotation(CjlNotNull.class);
            if(annotation!=null){
                declaredField.setAccessible(true);
                Object o = declaredField.get(t);
                if(o==null){
                    builder.append(declaredField+annotation.value());
                    throw new Exception(builder.toString());
                }
            }
        }
    }

}
