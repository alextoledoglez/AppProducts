package com.products.Backend.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.products.Backend.model.Product;
import com.products.Backend.repository.ProductsRepository;
import com.products.Backend.service.ProductService;

@RestController
public class ProductsController 
{
	    @Autowired
	    ProductService service;  //Service which will do all data retrieval/manipulation work
	 
	    
	    //-------------------Retrieve All products--------------------------------------------------------
	     
	    @RequestMapping(value = "/products/", method = RequestMethod.GET)
	    public ResponseEntity<List<Product>> listAllProducts() 
	    {
	        List<Product> products = service.findAllProducts();
	        
	        if(products.isEmpty())
	        {
	            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single Product--------------------------------------------------------
	     
	    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) 
	    {
	        System.out.println("Fetching Product with id " + id);
	        Product product = service.findById(id);
	        if (product == null) 
	        {
	            System.out.println("Product with id " + id + " not found");
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Product>(product, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a product--------------------------------------------------------
	     
	    @RequestMapping(value = "/product/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createProduct(@RequestBody Product product,    UriComponentsBuilder ucBuilder)
	    {
	 
	        if (service.isProductExist(product)) 
	        {
	            System.out.println("A Product with name " + product.getDescription() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }	           
	 
	        service.saveProduct(product);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a Product --------------------------------------------------------
	     
	    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) 
	    {
	        System.out.println("Updating Product " + id);
	         
	        Product currentProduct = service.findById(id);
	         
	        if (currentProduct == null) 
	        {
	            System.out.println("Product with id " + id + " not found");
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentProduct.setDescription(product.getDescription());
	        currentProduct.setDate(product.getDate());
	        currentProduct.setImage(product.getImage());
	        
	        currentProduct.setCoin(product.getCoin());
	        currentProduct.setPrice(product.getPrice());
	        //currentProduct.setPricer(product.getPricer());
	       // currentProduct.setPriced(product.getPriced());
	        currentProduct.setOrigen(product.getOrigen());
	        currentProduct.setCategory(product.getCategory());
	         
	        service.updateProduct(currentProduct);
	        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
	    }
	 
	    	    
	    //------------------- Delete a product --------------------------------------------------------
	    
	     
	    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) 
	    {
	        System.out.println("Fetching & Deleting Product with id " + id);
	 
	        Product product = service.findById(id);
	        if (product == null)
	        {
	            System.out.println("Unable to delete. Product with id " + id + " not found");
	            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	        }
	 
	        service.deleteProductById(id);
	        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Products --------------------------------------------------------
	     
	    @RequestMapping(value = "/product/", method = RequestMethod.DELETE)
	    public ResponseEntity<Product> deleteAllProducts() 
	    {
	        System.out.println("Deleting All Products");
	 
	        service.deleteAllProducts();
	        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	    }	
    
}
