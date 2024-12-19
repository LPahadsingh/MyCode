package com.Lopamudra.ecomSpringProject.repo;

import com.Lopamudra.ecomSpringProject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
