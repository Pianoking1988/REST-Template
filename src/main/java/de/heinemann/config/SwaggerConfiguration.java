package de.heinemann.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration for swagger documentation of the rest webservice.
 * 
 * The attributes like title, description or version have the name of the
 * property as default value, such that it is obvious in the GUI if they
 * are not filled and that a possible test can recognize it.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  @Value(value = "${swagger.title:swagger.title}")
  private String title;
  @Value(value = "${swagger.description:swagger.description}")
  private String description;
  @Value(value = "${swagger.version:swagger.version}")
  private String version;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("de.heinemann.rest"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(new ApiInfoBuilder()
            .title(title)
            .description(description)
            .version(version)
            .build());

  }
}
