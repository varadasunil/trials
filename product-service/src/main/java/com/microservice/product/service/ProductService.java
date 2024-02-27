package com.microservice.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.product.dto.ProductRequest;
import com.microservice.product.dto.ProductResponse;
import com.microservice.product.model.Product;
import com.microservice.product.repo.ProductRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepo productRepo;
	public void createProduct(ProductRequest productRequest) {
		
		System.out.println("here1");
		Product product=Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		
		System.out.println("here2");
		
		productRepo.save(product);
		log.info("product {} is saved",product.getId());
		
		
		
		
		
	}
	
	
	public List<ProductResponse> getAllProducts() {
		
		
		List<Product> products= productRepo.findAll();
		
		
		return products.stream().map(this::mapToProductResponse).toList();
		
		
		
	}
	
	
	public ProductResponse mapToProductResponse(Product product) {
		
		
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())				
				.build();
		
		
	}
}
