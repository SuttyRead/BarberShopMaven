package barbershop.dto;

public class OrderDTO {

    private int id;
    private int customerId;
    private int masterHandId;
//    private CustomerDTO customerDTO;
//    private MasterHandDTO masterHandDTO;
    private int cost;
//    private ServicesDTO servicesDTO;
    private int serviceId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMasterHandId() {
        return masterHandId;
    }

    public void setMasterHandId(int masterHandId) {
        this.masterHandId = masterHandId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

//    private static OrderDTO toDTO(Order order) {
//        return OrderDTO.builder()
//                .email(user.getEmail())
//                .id(user.getId())
//                .username(user.getUsername())
//                .build();
//    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", masterHandId=" + masterHandId +
                ", cost=" + cost +
                ", serviceId=" + serviceId +
                '}';
    }
}
