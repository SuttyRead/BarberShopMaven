package barbershop.dto;


import barbershop.domain.ServiceList;

public class ServicesDTO {

    private ServiceList serviceList;
    private int cost;

    public ServiceList getServiceList() {
        return serviceList;
    }

    public void setServiceList(ServiceList serviceList) {
        this.serviceList = serviceList;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ServicesDTO{" +
                "serviceList=" + serviceList +
                ", cost=" + cost +
                '}';
    }
}
