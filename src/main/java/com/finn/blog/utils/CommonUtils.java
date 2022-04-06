package com.finn.blog.utils;

import io.swagger.models.auth.In;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @description: 公共工具类
 * @author: Finn
 * @create: 2022/04/05 21:53
 */
public class CommonUtils {

    /*
     * @Description: 检查邮箱
     * @Param: [username]
     * @return: boolean
     * @Author: Finn
     * @Date: 2022/04/05 21:50
     */
    public static boolean checkEmail(String username) {
        String rule = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(rule);
        //正则表达式的匹配器
        Matcher m = p.matcher(username);
        //进行正则匹配
        return m.matches();
    }

    /*
    * @Description: 生成随机6位验证码
    * @Param: []
    * @return: java.lang.String
    * @Author: Finn
    * @Date: 2022/04/05 21:54
    */
    public static String getRandomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
