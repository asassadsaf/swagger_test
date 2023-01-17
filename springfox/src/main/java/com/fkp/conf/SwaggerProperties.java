package com.fkp.conf;

import com.google.common.base.Strings;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ConfigurationProperties(prefix = "common.swagger")
public class SwaggerProperties {

    private static final String SPLITTER = ",";

    private String basePackage;
    private String title = "REST API";
    private String description = "REST API Documentation";
    private String termsOfServiceUrl = "http://www.sansec.com.cn/";
    private String version = "1.0.0";

    private String headerParams;


    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHeaderParams() {
        return headerParams;
    }

    public void setHeaderParams(String headerParams) {
        this.headerParams = headerParams;
    }

    public List<String> getHeaderParamsList() {
        if(Strings.isNullOrEmpty(headerParams)) {
            return new ArrayList<>();
        }
        String[] params = headerParams.split(SPLITTER);
        return Arrays.asList(params);
    }
}
