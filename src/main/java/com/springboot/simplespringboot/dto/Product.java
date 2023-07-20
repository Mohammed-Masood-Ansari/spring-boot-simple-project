package com.springboot.simplespringboot.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	private int productId;
	private String productName;
	private String productColor;
	private double productPrice;
	

}
