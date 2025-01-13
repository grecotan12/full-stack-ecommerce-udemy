package com.luv2code.spring_boot_ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.luv2code.spring_boot_ecommerce.entity.Product;
import com.luv2code.spring_boot_ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // disable POST, PUT, DELETE for Product
        config.getExposureConfiguration()
              .forDomainType(Product.class)
              .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
              .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // disable POST, PUT, DELETE for ProductCategory
        config.getExposureConfiguration()
              .forDomainType(ProductCategory.class)
              .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
              .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
    
}
