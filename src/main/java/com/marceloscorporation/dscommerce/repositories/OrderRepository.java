package com.marceloscorporation.dscommerce.repositories;

import com.marceloscorporation.dscommerce.entities.Order;
import com.marceloscorporation.dscommerce.entities.User;
import com.marceloscorporation.dscommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {



}
