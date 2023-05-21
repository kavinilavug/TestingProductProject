package com.product.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.app.exception.ProductNotFoundException;
import com.product.app.model.Product;

@RestController
public class ProductController {

	@GetMapping("/product")
	List<Product> getProducts() {
		List<Product> pr = new ArrayList<>();
		pr.add(new Product(100, "phone", 9000, "", "high quality", 1));
		return pr;
	}

	@GetMapping("/product/{productid}")
	List<Product> getProducts(@PathVariable int productid) {
		List<Product> pr = new ArrayList<>();
		pr.add(new Product(100, "phone", 9000, "", "high quality", 1));
		return pr;
	}

	@PostMapping("/product")
	// @ResponseStatus(value=HttpStatus.CREATED)->if your are using the
	// @responsestatus can you use Responseentity
	// this is used for the status msg send to the client
	ResponseEntity<Product> addProducts(@RequestBody Product product) {
		if (product.getName() == "") {
			throw new ProductNotFoundException();
		}
		return new ResponseEntity<>(product, HttpStatus.CREATED);
		// TODO Auto-generated method stub

	}

	@PutMapping("/product/{productId}")
	ResponseEntity<Product> updateProducts(@PathVariable int productId,@RequestBody Product product) {
		return new ResponseEntity<>(HttpStatus.OK);
		// TODO Auto-generated method stub

	}
	
	@PatchMapping("/product/{productId}/{productname}")
	ResponseEntity<Product> updateProducts(@PathVariable int productId,@PathVariable String productname) {
		return new ResponseEntity<>(HttpStatus.OK);
		// TODO Auto-generated method stub

	}
	
	@DeleteMapping("/product/{productId}")
	ResponseEntity<Product> deleteProducts(@PathVariable int productId) {
		return new ResponseEntity<>(HttpStatus.OK);
		// TODO Auto-generated method stub

	}
}
