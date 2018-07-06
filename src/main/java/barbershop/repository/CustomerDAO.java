package barbershop.repository;

import barbershop.domain.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getAllCustomers();

    Customer findCustomerById(int id);

    void addCustomer(Customer customer);

}
