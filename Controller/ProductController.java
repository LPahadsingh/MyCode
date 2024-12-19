package com.Lopamudra.ecomSpringProject.Controller;

import com.Lopamudra.ecomSpringProject.Entity.Product;
import com.Lopamudra.ecomSpringProject.Service.ProductService;
import com.Lopamudra.ecomSpringProject.Model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api")
public class ProductController {

@RequestMapping("/")
    public String greet(){
        return "Hello World";
    }
    @Autowired
private ProductService service;

     @GetMapping("/products")
   public List<Product> getAllproducts() {
         return service.getAllProducts();
     }
         @PostMapping("/add")
public String addproduct(@RequestBody ProductRequest product){
    service.addProduct(product);
    return "product added succesfully";
}

@GetMapping("/products/{id}")
public ProductRequest getProduct(@PathVariable Integer id){
    return service.getProductById(id);
}

}
