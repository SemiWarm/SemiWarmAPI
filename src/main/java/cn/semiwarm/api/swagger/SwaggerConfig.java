package cn.semiwarm.api.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置文件
 * Created by alibct on 2017/2/28.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createUserInfo() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        Contact contact = new Contact("方浪", "www.semiwarm.cn", "alibct@163.com");
        ApiInfo apiInfo = new ApiInfo("API文档说明", "SemiWarm API文档", "V1.0", "", contact, "", "");
        docket.apiInfo(apiInfo);
        return docket;
    }
}
