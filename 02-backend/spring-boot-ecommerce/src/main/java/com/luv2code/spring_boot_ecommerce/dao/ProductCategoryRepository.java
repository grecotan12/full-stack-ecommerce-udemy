package com.luv2code.spring_boot_ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.luv2code.spring_boot_ecommerce.entity.ProductCategory;

@CrossOrigin("https://4200-grecotan12-fullstackeco-lkahhatu5a3.ws-us117.gitpod.io/")
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
