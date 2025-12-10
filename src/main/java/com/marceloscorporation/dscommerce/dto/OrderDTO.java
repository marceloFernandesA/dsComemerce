package com.marceloscorporation.dscommerce.dto;

import com.marceloscorporation.dscommerce.entities.Order;
import com.marceloscorporation.dscommerce.entities.OrderItem;
import com.marceloscorporation.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;

    private ClientDTO client;

    private PaymentDTO payment;

    @NotEmpty(message = "Deve ter pelo menos uma item" )
    private List <OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO() {

    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        client = new ClientDTO(entity.getClient());
        payment = (entity.getPayment()==null) ? null : new PaymentDTO(entity.getPayment());
        for(OrderItem item : entity.getItems()){
            OrderItemDTO itemDTO = new OrderItemDTO(item);
            items.add(itemDTO);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItemDTO item : items) {
            sum = sum + item.getSubTotal();
        }

        return sum;

    }
}
