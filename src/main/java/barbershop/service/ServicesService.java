package barbershop.service;


import barbershop.domain.Services;
import barbershop.repository.impl.ServicesDAOH2Impl;

import java.util.List;

public class ServicesService {

    private ServicesDAOH2Impl servicesDAO;

    public ServicesService() {
        servicesDAO = ServicesDAOH2Impl.instance();
    }

    public List<Services> getAllServices() {
        return servicesDAO.getAllServices();
    }

    public void addService(Services service) {
        servicesDAO.addService(service);
    }

    public void deleteService(int id) {
        servicesDAO.deleteService(id);
    }

    public void updateService(Services services) {
        servicesDAO.updateService(services);
    }

    public Services findServicesById(int id) {
        return servicesDAO.findServicesById(id);
    }

}
