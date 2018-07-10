package barbershop.service;

import barbershop.domain.Service;
import barbershop.repository.impl.ServiceDAOH2impl;

import java.util.List;

public class ServiceService {
    private ServiceDAOH2impl serviceDAOH2impl = new ServiceDAOH2impl();

    public void addService(Service service) {
        serviceDAOH2impl.addService(service);
    }

    public void deleteService(int id) {
        serviceDAOH2impl.deleteService(id);
    }

    public List<Service> getAllService() {
        return serviceDAOH2impl.getAllService();
    }

}
