package com.bwie.manager.configuration;

import com.bwie.manager.controller.ProductController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program:financial
 * @description:
 * @author:Mr.WeiLa
 * @create:2019-09-1108:51
 **/
//@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("controller")
                .apiInfo(apiInfo())
//                .select()
                //只显示指定包下的接口
                .select().apis(RequestHandlerSelectors.basePackage(ProductController.class.getPackage().getName()))
                //通过url来控制接口的显示
//                .paths(PathSelectors.ant("/products/*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HTTP API")
                .description("管理端接口")
                .termsOfServiceUrl("http://springfox.io")
                .contact("weijinle")
                .license("Apache License Version 2.0")
                .version("2.0")
                .build();
    }
}
