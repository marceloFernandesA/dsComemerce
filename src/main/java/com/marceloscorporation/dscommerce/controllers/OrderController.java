package com.marceloscorporation.dscommerce.controllers;

import com.marceloscorporation.dscommerce.dto.OrderDTO;
import com.marceloscorporation.dscommerce.dto.ProductDto;
import com.marceloscorporation.dscommerce.dto.ProductMinDto;
import com.marceloscorporation.dscommerce.services.OrderService;
import com.marceloscorporation.dscommerce.services.ProductService;
import com.marceloscorporation.dscommerce.services.execeptions.DataBaseException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    //a@PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }



}
