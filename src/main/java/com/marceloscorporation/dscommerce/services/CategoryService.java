package com.marceloscorporation.dscommerce.services;

import com.marceloscorporation.dscommerce.dto.CategoryDTO;
import com.marceloscorporation.dscommerce.dto.ProductDto;
import com.marceloscorporation.dscommerce.dto.ProductMinDto;
import com.marceloscorporation.dscommerce.entities.Category;
import com.marceloscorporation.dscommerce.entities.Product;
import com.marceloscorporation.dscommerce.repositories.CategoryRepository;
import com.marceloscorporation.dscommerce.repositories.ProductRepository;
import com.marceloscorporation.dscommerce.services.execeptions.DataBaseException;
import com.marceloscorporation.dscommerce.services.execeptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findByAll(){
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();

    }

}
