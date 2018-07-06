package barbershop.service;


import barbershop.domain.Customer;
import barbershop.domain.MasterHand;
import barbershop.domain.Order;
import barbershop.domain.Services;
import barbershop.dto.OrderDTO;
import barbershop.repository.impl.OrderDAOH2Impl;

import java.util.List;

public class OrderService {

    private OrderDAOH2Impl orderDAOH2;

    public OrderService() {
        orderDAOH2 = OrderDAOH2Impl.instance();
    }

    public void addOrder(Order order) {
        orderDAOH2.addOrder(order);
    }

    public List<Order> getAllOrders() {
        CustomerService customerService = new CustomerService();
        ;
        List<Order> orders = orderDAOH2.getAllOrders();
//        List<OrderDTO> orderDTOS = orders.stream();

        Customer customer = new Customer();
        MasterHand masterHand = new MasterHand();
        Services services = new Services();
        orders.get(1);
        return orderDAOH2.getAllOrders();
    }

    public void deleteOrder(int id) {
        orderDAOH2.deleteOrder(id);
    }

}
