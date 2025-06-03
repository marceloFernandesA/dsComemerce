package com.marceloscorporation.dscommerce.services;

import com.marceloscorporation.dscommerce.dto.ProductDto;
import com.marceloscorporation.dscommerce.entities.Product;
import com.marceloscorporation.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id){
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDto dto = new ProductDto(product);
        return dto;
    }




}
