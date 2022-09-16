package com.fkp.conf;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI springApi(@Value("${springdoc.version}") String version) {
        return new OpenAPI()
                .components(new Components()
                        // key值，对应接口上方的name
                        .addSecuritySchemes("Authorization",
                                new SecurityScheme()
                                        //请求认证类型
                                        .type(SecurityScheme.Type.APIKEY)
                                        //密钥名称
                                        .name("Authorization")
                                        //描述
                                        .description("token令牌1")
                                        //API密钥的位置。有效值"query","header"或"cookie")
                                        .in(SecurityScheme.In.HEADER)))
                .info(new Info()
                        .title("API接口")
                        .version(version)
                        .description("api接口文档")
                        .termsOfService("http://swagger.io/terms/"));
    }
}
