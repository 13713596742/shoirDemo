package janker.shirodemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ： CatalpaFlat
 * @date ：Create in 10:39 2018/2/10
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createAPI() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("X-Access-Token").description("X-Access-Token安全验证")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("MzYwMDMxN2Q1MjA0ZDM5ZTg0ZmI1NWU5")
                .required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_12)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("janker.shirodemo.idal"))
//                .apis(RequestHandlerSelectors.any())
                //过滤生成链接
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .useDefaultResponseMessages(false).
                        securitySchemes(Collections.singletonList(apiKey()))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        springfox.documentation.service.Contact contact = new springfox.documentation.service.Contact("Dankal", "", "1229446948@qq.com");

        return new ApiInfoBuilder().title("剑客").description("服务端接口文档").contact(contact).version("1.0.0").build();
    }

    @Bean
    public SecurityScheme apiKey() {
        return new ApiKey("access_token", "X-Access-Token", "header");
    }

}

