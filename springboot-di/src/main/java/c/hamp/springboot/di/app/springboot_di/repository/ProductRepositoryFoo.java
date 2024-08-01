package c.hamp.springboot.di.app.springboot_di.repository;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import c.hamp.springboot.di.app.springboot_di.models.Product;


@Repository
public class ProductRepositoryFoo  implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Asus", 500L));
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


}
