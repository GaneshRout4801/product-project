package com.product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info =
                   @Info(
						   title="product service rest Api documentation",
						   description = "product service Rest Api",
						   version="v1",
						   contact = @Contact(
								   name = "Ganesh Rout",
								   email = "ganeshrour4801@Gmail.com"
						   )
				   ))
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
