package com.service.provider.user.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket userApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.service.provider.user.controller"))//过滤的接口
                .paths(PathSelectors.any())
                .build();
        return docket;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("ServiceProvider").description("服务相关数据接口")
                .termsOfServiceUrl("http://github.com/").contact("Free_Lei")
                .license("Licence Version 1.0").licenseUrl("#").version("1.0").build();
    }

}
