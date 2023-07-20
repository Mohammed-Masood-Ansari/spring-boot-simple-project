package com.springboot.simplespringboot.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.simplespringboot.dao.ProductDao;
import com.springboot.simplespringboot.dto.Product;
import com.springboot.simplespringboot.response.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ResponseStructure<Product> responseStructure;

	/*
	 * insertProduct method
	 */
	public Product insertProduct(Product product) {
		
		if(product.getProductPrice()<=40000) {
			return productDao.insertProduct(product);
		}else {
			return null;
		}
	}
	
	/*
	 * insertMultipleProduct
	 */
	public List<Product> insertMultipleProducts(List<Product> products){
		
		List<Product> products2 = new ArrayList<Product>();
		
		for (Product product : products) {
			
			if(product.getProductPrice()<=40000) {
				
				products2.add(product);
				
			}
		}
		
		return productDao.insertMultipleProducts(products2);
	}
	
	/*
	 * deleteProduct
	 */
	public ResponseStructure<Product> deleteProductById(int productId) {
		Product product =productDao.getProductById(productId);
		if(product!=null) {
			productDao.deleteProductById(productId);
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Data---Deleted");
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setDescription("fdhjgklnlm");
			responseStructure.setData(product);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("Given---Id----is--Not---Acceptable");
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setDescription("Data---Not---Deleted");
			responseStructure.setData(product);
		}
		return responseStructure;
	}
	
	/*
	 *getProductById
	 */
	public ResponseStructure<Product> getProductById(int productId) {
		
		Product product=productDao.getProductById(productId);
		
		if(product!=null) {
			
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Success");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
			
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setDateTime(LocalDateTime.now());
			responseStructure.setStatusMessage("Given----Id---is---not---Present");
			responseStructure.setDescription("com.springboot.simplespringboot.dto.Product");
			responseStructure.setData(product);
		}
		
		return responseStructure;
	}
	
	/*
	 * updateProductNameById
	 */
	public Product updateProductById(Product product) {
		return productDao.updateProductById(product);
	}
}
