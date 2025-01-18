package com.luv2code.spring_boot_ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.luv2code.spring_boot_ecommerce.entity.Product;

@CrossOrigin("https://4200-grecotan12-fullstackeco-lkahhatu5a3.ws-us117.gitpod.io/")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
