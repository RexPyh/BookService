package com.pyh.bookservice.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IdUtil {

    //构造方法
    public IdUtil() {
    }

    //随机生成6位不重复id
    public String getRandomId(){

        String id = "";
        for (int i = 0; i <= 100; i++)
        {
            String sources = "0123456789";
            Random rand = new Random();
            StringBuffer flag = new StringBuffer();
            for (int j = 0; j < 6; j++)
            {
                flag.append(sources.charAt(rand.nextInt(9)) + "");
            }
            id = flag.toString();
        }
        return id;
    }
}
