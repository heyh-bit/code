package com.heyh.baseframework.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "swagger") //可通过该注解将属性配置到application.yaml配置文件中
public class SwaggerProperties {
    private boolean enable = true;

    private String version;

    private String name;

    private String email;

    private String title;

    private String description;

    private String url;
}
