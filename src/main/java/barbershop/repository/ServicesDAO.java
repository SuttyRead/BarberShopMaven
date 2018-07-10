package barbershop.repository;

import barbershop.domain.Services;


import java.util.List;

public interface ServicesDAO {

    List<Services> getAllServices();

    Services findServicesById(int id);

    void addService(Services services);

    void deleteService(int id);

    void updateService(Services services);

}
