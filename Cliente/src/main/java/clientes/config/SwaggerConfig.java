package clientes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	 @Bean
	    public Docket api() { 
	     
	    	Docket docket =  new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("clientes.api"))
	        .paths(PathSelectors.any())
	        .build()
	        .useDefaultResponseMessages(false)
	        .apiInfo(apiInfo());
	        
	        
	        return docket;
	    }
	    
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title(" API REST de Cadastro de clientes")
	                .description("Este e um projeto desenvolvido, para aula de tópicos avançados")
	                .version("1.0.0")                
	                .contact(new Contact("Jose Sutel", "", "joseeduardosutel6650@gmail.com"))
	                .build();
	    }
	    
	   
}
