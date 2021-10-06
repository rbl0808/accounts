package com.rbl.accounts.config;

import springfox.documentation.service.ApiInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getUserDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                //api标题
                .title("记账本")
                //api描述
                .description("记账本相关接口描述")
                //版本号
                .version("1.0.0")
                //本API负责人的联系信息
                .contact("rbl")
                .build();
        //文档类型（swagger2）
        return new Docket(DocumentationType.SWAGGER_2)
                //设置包含在json ResourceListing响应中的api元信息
                .apiInfo(apiInfo)
                //启动用于api选择的构建器
                .select()
                //扫描接口的包
                .apis(RequestHandlerSelectors.basePackage("com.rbl.accounts.controller"))
                //路径过滤器（扫描所有路径）
                .paths(PathSelectors.any())
                .build();
    }
}
