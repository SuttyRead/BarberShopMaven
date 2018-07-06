package barbershop.repository;

import barbershop.domain.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder(Order order);

    List<Order> getAllOrders();

    void deleteOrder(int id);

}
