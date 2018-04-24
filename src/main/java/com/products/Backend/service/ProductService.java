package com.products.Backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

import com.products.Backend.model.Product;

public interface ProductService 
{
	
	Product findById(long id);
	
	Product findByDescription(String description);
	
	void saveProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProductById(long id);

	List<Product> findAllProducts(); 
	
	void deleteAllProducts();
	
	public boolean isProductExist(Product user);
	
}
