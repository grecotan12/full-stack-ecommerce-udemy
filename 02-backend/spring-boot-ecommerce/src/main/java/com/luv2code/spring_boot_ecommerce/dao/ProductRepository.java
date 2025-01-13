package com.luv2code.spring_boot_ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.spring_boot_ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
