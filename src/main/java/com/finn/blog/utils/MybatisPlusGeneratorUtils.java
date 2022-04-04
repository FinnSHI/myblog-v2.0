package com.finn.blog.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.Scanner;

/*
 * @description: Mybatisplue自动生成工具类
 * @author: Finn
 * @create: 2022/04/04 16:13
 */
public class MybatisPlusGeneratorUtils {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /*
     * @Description: 自动生成package和类
     * @Param: [args]
     * @return:  null
     * @Author: Finn
     * @Date: 2022/1/20
     */
    public static void main(String[] args) {
        String moduleName = "blog-web";
        String tableName = scanner("表名");

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/blog-v2.0?useUnicode=true&characterEncoding=utf-8&userSSL=false&serverTimezone=GMT%2B8",
                        "root",
                        "admin")
                .globalConfig(builder -> {
                    builder.author("finn") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\myblog\\myblog-v1.0\\" + moduleName + "\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.finn") // 设置父包名
//                            .moduleName("blog-web") // 设置父包模块名
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.serviceImpl")
                            .controller("controller")
                            .mapper("dao")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:\\myblog\\myblog-v1.0\\" + moduleName + "\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName) // 设置需要生成的表名
                            .addTablePrefix("tb_"); // 设置过滤表前缀，生成的entity等名字过滤前缀
                })
                .strategyConfig(builder -> {
                            builder.entityBuilder().enableLombok().enableChainModel();// 开启生成@RestController 控制器;
                        }
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
