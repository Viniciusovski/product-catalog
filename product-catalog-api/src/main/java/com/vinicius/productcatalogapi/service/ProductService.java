package com.vinicius.productcatalogapi.service;

import com.vinicius.productcatalogapi.model.Product;
import com.vinicius.productcatalogapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Cacheable(value = "product", key = "#id")
    public Optional<Product> getById(String id) {
        return productRepository.findById(id);
    }

    @Cacheable("products")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> update(String id, Product productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setTitle(productDetails.getTitle());
                    product.setDescription(productDetails.getDescription());
                    product.setPrice(productDetails.getPrice());
                    product.setOwnerId(productDetails.getOwnerId());
                    product.setCategory(productDetails.getCategory());
                    return productRepository.save(product);
                });
    }

    public boolean delete(String id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return true;
                }).orElse(false);
    }
}