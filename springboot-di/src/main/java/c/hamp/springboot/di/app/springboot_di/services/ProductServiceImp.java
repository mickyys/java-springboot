package c.hamp.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import c.hamp.springboot.di.app.springboot_di.models.Product;
import c.hamp.springboot.di.app.springboot_di.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Autowired
    private Environment environment;;

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            System.out.println("environment " + environment.getProperty("config.price.tax", Double.class));
            Double priceImp = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

}
