package c.hamp.springboot.di.app.springboot_di.repository;

import java.util.List;

import c.hamp.springboot.di.app.springboot_di.models.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
