package com.marceloscorporation.dscommerce.services;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.marceloscorporation.dscommerce.dto.ProductDto;
import com.marceloscorporation.dscommerce.entities.Product;
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
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id){
            Optional<Product> result = repository.findById(id);
            Product product = result.orElseThrow(
                    ()-> new ResourceNotFoundException("Recurso não encontrado"));
            ProductDto dto = new ProductDto(product);
            return dto;
    }

    @Transactional(readOnly = true)
    public Page<ProductDto> findByAll(String name,Pageable pageable){
        Page<Product> result = repository.searchByName(name,pageable);
        return result.map(x -> new ProductDto(x));

    }

    @Transactional
    public ProductDto insert(ProductDto dto){
       Product entity = new Product();
       copyDtoToEntity(dto,entity);
       entity = repository.save(entity);

       return new ProductDto(entity);
    }

    @Transactional
    public ProductDto update(Long id,ProductDto dto){
       try {

           Product entity = repository.getReferenceById(id);
           copyDtoToEntity(dto,entity);
           entity = repository.save(entity);

           return new ProductDto(entity);
       }
       catch (EntityNotFoundException e){
           throw new  ResourceNotFoundException("Recurso não encontrado");
       }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) throws DataBaseException {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha de integridade referencial");
        }
    }

        private void copyDtoToEntity(ProductDto dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }



}
