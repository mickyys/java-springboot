package c.hamp.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import c.hamp.springboot.di.app.springboot_di.repository.ProductRepository;
import c.hamp.springboot.di.app.springboot_di.repository.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:json/products.json")
    private Resource resource;

    @Bean
    @Primary
    ProductRepository productRepository (){
        return new ProductRepositoryJson(resource);
    }

}
