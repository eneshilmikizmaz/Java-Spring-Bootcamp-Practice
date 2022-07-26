package com.logo.service;

import com.logo.DAO.ProductJdbcConnection;
import com.logo.DAO.ProductJdbcTemplateConnection;
import com.logo.model.Product;
import com.logo.model.User;
import com.logo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductJdbcTemplateConnection productJdbcTemplateConnection;

	public Product createProduct(Product productRequest) {
		return productJdbcTemplateConnection.create(productRequest);
		//return productRepository.save(productRequest);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product updateProduct(Product product) {
		Product foundProduct = productRepository.findById(product.getId()).get();
		foundProduct.setName(product.getName());
		foundProduct.setPrice(product.getPrice());

		return productRepository.save(foundProduct);
	}

	public void deleteProductById(int productId) {
		Product foundProduct = productRepository.findById(productId).get();
		productRepository.delete(foundProduct);
	}
}
