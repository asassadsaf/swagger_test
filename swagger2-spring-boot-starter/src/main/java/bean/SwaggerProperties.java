package bean;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author fengkunpeng
 */
@ConfigurationProperties(prefix = "common.swagger")
@Getter
@Setter
public class SwaggerProperties {

    private static final String SPLITTER = ",";
    private static final String AUTHORIZATION = "Authorization";

    private String basePackage;
    private String title = "REST API";
    private String description = "REST API Documentation";
    private String termsOfServiceUrl = "http://www.sansec.com.cn/";
    private String version = "1.0.0";
    private String headerParams;
    private String headerApiKeys;
    private String queryApiKeys;

    public List<String> getHeaderApiKeysList(){
        if (StringUtils.isBlank(headerApiKeys)){
            return Collections.singletonList(AUTHORIZATION);
        }
        return Arrays.asList(headerApiKeys.split(SPLITTER));
    }

    public List<String> getQueryApiKeysList(){
        if(StringUtils.isBlank(queryApiKeys)){
            return Collections.emptyList();
        }
        return Arrays.asList(queryApiKeys.split(SPLITTER));
    }

    public List<String> getHeaderParamsList() {
        if(StringUtils.isBlank(headerParams)) {
            return Collections.emptyList();
        }
        return Arrays.asList(headerParams.split(SPLITTER));
    }
}
