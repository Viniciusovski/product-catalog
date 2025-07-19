package com.vinicius.productcatalogapi.service;

import com.vinicius.productcatalogapi.model.Category;
import com.vinicius.productcatalogapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Cacheable(value = "category", key = "#id")
    public Optional<Category> getById(String id) {
        return categoryRepository.findById(id);
    }

    @Cacheable("categories")
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> update(String id, Category categoryDetails) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setTitle(categoryDetails.getTitle());
                    category.setDescription(categoryDetails.getDescription());
                    category.setOwnerId(categoryDetails.getOwnerId());
                    return categoryRepository.save(category);
                });
    }

    public boolean delete(String id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryRepository.delete(category);
                    return true;
                }).orElse(false);
    }
}