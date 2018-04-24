package com.products.Backend.repository;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.products.Backend.model.Product;

public interface ProductsRepository extends CrudRepository<Product, Long>
{
	  Product findByDescription(String Description);
}

