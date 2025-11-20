package com.marceloscorporation.dscommerce.controllers;

import com.marceloscorporation.dscommerce.dto.CategoryDTO;
import com.marceloscorporation.dscommerce.dto.ProductDto;
import com.marceloscorporation.dscommerce.dto.ProductMinDto;
import com.marceloscorporation.dscommerce.services.CategoryService;
import com.marceloscorporation.dscommerce.services.ProductService;
import com.marceloscorporation.dscommerce.services.execeptions.DataBaseException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
       List<CategoryDTO>list = service.findByAll();
        return ResponseEntity.ok(list);
    }


}
