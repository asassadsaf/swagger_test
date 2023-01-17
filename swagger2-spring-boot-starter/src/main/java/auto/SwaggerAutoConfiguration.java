package auto;

import bean.SwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fengkunpeng
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
//标注在配置类上，当启动环境为dev时才加载@Bean标注bean
@Profile("dev")
@ConditionalOnClass(EnableSwagger2.class)
@ConditionalOnProperty(prefix = "common.swagger", value = "enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration {

    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket createApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

        List<String> headerParamsList = swaggerProperties.getHeaderParamsList();
        if(headerParamsList != null && !headerParamsList.isEmpty()){
            List<Parameter> headerParameters = createHeaderParameters(headerParamsList);
            docket.globalOperationParameters(headerParameters);
        }

        return docket;
    }

    private List<Parameter> createHeaderParameters(List<String> headerParamList) {
        List<Parameter> parameters = new ArrayList<>();
        for (String param : headerParamList) {
            parameters.add(createHeaderParameter(param));
        }
        return parameters;
    }

    private Parameter createHeaderParameter(String headerParams) {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        return parameterBuilder.name(headerParams)
                .description(headerParams)
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .version(swaggerProperties.getVersion())
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return new ArrayList<>(Collections.singleton(new ApiKey(AUTHORIZATION, AUTHORIZATION, "header")));
    }

    private List<SecurityContext> securityContexts() {
        return new ArrayList<>(Collections.singleton(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build()));
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return new ArrayList<>(Collections.singleton(
                new SecurityReference(AUTHORIZATION, authorizationScopes)));
    }
}
