package bean;

import com.google.common.base.Strings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fengkunpeng
 */
@ConfigurationProperties(prefix = "common.swagger")
@Getter
@Setter
public class SwaggerProperties {

    private static final String SPLITTER = ",";

    private String basePackage;
    private String title = "REST API";
    private String description = "REST API Documentation";
    private String termsOfServiceUrl = "http://www.sansec.com.cn/";
    private String version = "1.0.0";
    private String headerParams;

    public List<String> getHeaderParamsList() {
        if(Strings.isNullOrEmpty(headerParams)) {
            return new ArrayList<>();
        }
        String[] params = headerParams.split(SPLITTER);
        return Arrays.asList(params);
    }
}
