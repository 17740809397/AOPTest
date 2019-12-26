package com.htsc.carma.carma.dao;

import com.htsc.carma.carma.myanotation.CjlNotNull;
import lombok.Data;

/**
 * @author DELL
 */
@Data
public class User {

    @CjlNotNull("不能为空")
    private String name;

    private String age;
}
