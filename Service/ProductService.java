package com.Lopamudra.ecomSpringProject.Service;

import com.Lopamudra.ecomSpringProject.Entity.Product;
import com.Lopamudra.ecomSpringProject.Model.ProductRequest;
import com.Lopamudra.ecomSpringProject.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    public ProductRepo repo;
    public void addProduct(ProductRequest product) {
        Product productEntity= new Product();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setAvailable(product.isAvailable());
        productEntity.setCategory(product.getCategory());
        productEntity.setBrand(product.getBrand());
        productEntity.setDescription(product.getDescription());
        productEntity.setReleaseDate(product.getReleaseDate());
        repo.save(productEntity);
        System.out.println("Product saved: " + product);
    }
    public ProductRequest getProductById(Integer id) {
        Optional<Product> product = repo.findById(id);
        if (product.isPresent()) {
          Product productEntity=product.get();
          return new ProductRequest(
                  productEntity.getId(),
                  productEntity.getName(),
                  productEntity.getDescription(),
                  productEntity.getCategory(),
                  productEntity.isAvailable(),
                  productEntity.getPrice(),
                  productEntity.getBrand(),
                  productEntity.getReleaseDate(),
                  productEntity.getQuantity()
          );
        }



        throw new RuntimeException("Product not found with ID: " + id);
    }
    public List<Product> getAllProducts(){
      return repo.findAll();
    }
}
