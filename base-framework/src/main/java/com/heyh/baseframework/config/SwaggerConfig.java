package com.heyh.baseframework.config;

import com.heyh.baseframework.config.props.SwaggerProperties;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    SwaggerProperties swaggerProperties;

    @Bean
    public Docket docket() {

        //添加header参数
        RequestParameterBuilder ticketPar = new RequestParameterBuilder();

        List<RequestParameter> pars = new ArrayList<>();
        ticketPar
                .name("Authorization")
                .description("user token")
                .in(ParameterType.HEADER)
                .required(false)
                .build();
        pars.add(ticketPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerProperties.isEnable())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .build()
                .globalRequestParameters(pars);
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(swaggerProperties.getName(), swaggerProperties.getUrl(), swaggerProperties.getEmail());
        return new ApiInfo(
                swaggerProperties.getTitle()
                ,swaggerProperties.getDescription()
                ,swaggerProperties.getVersion()
                ,""
                ,contact,""
                ,""
                ,new ArrayList<>());
    }
}
