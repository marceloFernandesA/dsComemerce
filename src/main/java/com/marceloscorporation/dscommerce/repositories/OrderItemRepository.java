package com.marceloscorporation.dscommerce.repositories;

import com.marceloscorporation.dscommerce.entities.Order;
import com.marceloscorporation.dscommerce.entities.OrderItem;
import com.marceloscorporation.dscommerce.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {



}
