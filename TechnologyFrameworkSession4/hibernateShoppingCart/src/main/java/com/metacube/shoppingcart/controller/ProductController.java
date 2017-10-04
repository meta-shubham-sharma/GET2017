package com.metacube.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;

/**
 * The Class ProductController.
 
 * The Class ProductController.
 * 
 * This class use is responsible to direct the service on right page
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	/** The product facade. */
	/** The product facade. */
	@Autowired
	ProductFacade productFacade;


	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@RequestMapping(value="/list", produces ="application/json")
	public @ResponseBody Iterable<ProductDto> getProducts() {
		return productFacade.getAllProducts();

	}

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	@RequestMapping(value="/get/{id}" , produces="application/json")
	public @ResponseBody ProductDto getProductById(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}

	/**
	 * Delete product by id.
	 *
	 * @param id the id
	 * @return the response
	 */
	@RequestMapping(value="/delete/{id}" , produces="application/json")
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id){
		return productFacade.deleteProduct(id);
	}
	
	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return the response
	 */
	@RequestMapping(value="/add")
	public @ResponseBody Status addProduct(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}
	/**
	 * Edits the product.
	 *
	 * @param product the product
	 * @param id the id
	 * @return the response
	 */
	@RequestMapping(value="/edit/{id}" , produces="application/json")
	public @ResponseBody Status editProduct( @RequestBody Product product,@PathVariable("id") int id) {
		return productFacade.editProduct(product,id);
	}
}
