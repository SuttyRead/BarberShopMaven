package barbershop.service;

import barbershop.domain.Order;
import barbershop.dto.OrderDTO;
import barbershop.repository.impl.OrderDAOH2Impl;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    private OrderDAOH2Impl orderDAOH2;

    public OrderService() {
        orderDAOH2 = OrderDAOH2Impl.instance();
    }

    public void addOrder(Order order) {
        orderDAOH2.addOrder(order);
    }

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderDAOH2.getAllOrders();
        return orders.stream()
                .map(OrderDTO::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteOrder(int id) {
        orderDAOH2.deleteOrder(id);
    }

}
