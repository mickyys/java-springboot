package c.hamp.springboot.di.app.springboot_di.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import c.hamp.springboot.di.app.springboot_di.models.Product;


@Repository
public class ProductRepositoryImp implements ProductRepository {
    
    private List<Product> products;
    
    public ProductRepositoryImp(){
        this.products = Arrays.asList(
            new Product(1L, "Memoria Tokita", 300L),
            new Product(2L, "Disco Tokita", 600L),
            new Product(3L, "Monitor Tokita", 200L),
            new Product(4L, "Moouse Tokita", 50L)
        );
    };

    @Override
    public List<Product> findAll(){
        return products;
    }

    @Override
    public Product findById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
