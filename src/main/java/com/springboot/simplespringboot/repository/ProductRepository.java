package com.springboot.simplespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.simplespringboot.dto.Product;

/*
 * 
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
