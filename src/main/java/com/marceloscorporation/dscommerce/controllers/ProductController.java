package com.marceloscorporation.dscommerce.controllers;

import com.marceloscorporation.dscommerce.dto.ProductDto;
import com.marceloscorporation.dscommerce.entities.Product;
import com.marceloscorporation.dscommerce.repositories.ProductRepository;
import com.marceloscorporation.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id) {
        ProductDto dto = service.findById(id);
        return dto;
    }

    @GetMapping
    public Page<ProductDto> findAll(Pageable pageable){
        return service.findByAll(pageable);
    }


}
