package com.products.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.products.Backend.model.Product;
import com.products.Backend.repository.ProductsRepository;


@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService
{
	
	@Autowired
	private ProductsRepository repository;
	

	public List<Product> findAllProducts() 
	{
		return (List<Product>) repository.findAll();
	}
	
	public Product findById(long id) 
	{
		return repository.findOne(id);
	}
	
	public Product findByDescription(String description) 
	{
		return repository.findByDescription(description);
	}
		
	public void saveProduct(Product product) 
	{
		repository.save(product);
	}

	public void updateProduct(Product product) 
	{
		repository.save(product);
	}

	public void deleteProductById(long id) 
	{
		repository.delete(id);
	}

	public boolean isProductExist(Product product) 
	{
		return findByDescription(product.getDescription())!=null;
	}
	
	public void deleteAllProducts()
	{
		repository.deleteAll();
	}



}
