package com.marceloscorporation.dscommerce.services;

import com.marceloscorporation.dscommerce.dto.OrderDTO;
import com.marceloscorporation.dscommerce.entities.Order;
import com.marceloscorporation.dscommerce.repositories.OrderRepository;
import com.marceloscorporation.dscommerce.services.execeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado") );

                return new OrderDTO(order);
    }


}
