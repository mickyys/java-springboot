package c.hamp.springboot.di.app.springboot_di.repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import c.hamp.springboot.di.app.springboot_di.models.Product;

public class ProductRepositoryJson implements ProductRepository {

    private List<Product> products;

    public ProductRepositoryJson(Resource resource) {
        readValueJSON(resource);
    }

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/products.json");
        readValueJSON(resource);
    }

    private void readValueJSON(Resource resource){
        ObjectMapper mapper = new ObjectMapper();
        try {
            products = Arrays.asList(mapper.readValue(resource.getFile(), Product[].class));
        } catch (StreamReadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatabindException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    

}
