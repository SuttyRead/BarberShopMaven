package barbershop.repository;

import barbershop.domain.Service;

import java.util.List;

public interface ServiceDAO {

    void addService(Service service);

    void deleteService(int id);

    List<Service> getAllService();

}
