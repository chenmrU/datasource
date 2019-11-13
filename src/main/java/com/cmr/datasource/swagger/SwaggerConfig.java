package com.cmr.datasource.swagger;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmengrui
 * @Description: swagger配置
 * @date 2019/11/8 15:46
 */
@Configuration
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket petApi() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder().name("token").modelRef(new ModelRef("string")).description("token").parameterType("header").required(false).build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(Predicates.not(PathSelectors.regex("/actuator.*")))
                .paths(Predicates.not(PathSelectors.regex("/profile.*")))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .globalOperationParameters(parameters);
    }

    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("datasource").build();
    }

}
