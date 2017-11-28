package com.pers.lzl.export;

import com.pers.lzl.modules.dpt.entity.ShoeTreeDataVo;
import java.lang.reflect.Field;

public class TestClass {

    public static void main(String[] args) {
        Field[] fs = ShoeTreeDataVo.class.getDeclaredFields();
        for (Field field : fs) {
            System.out.println(field);
        }
    }
}
