package com.htsc.carma.carma.myanotation;

import java.lang.annotation.*;

/**
 * @author DELL
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CjlNotNull {

    String value();
}
