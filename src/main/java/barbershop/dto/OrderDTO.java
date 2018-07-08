package barbershop.dto;


import barbershop.domain.Order;
import lombok.Builder;
import lombok.Data;


public class OrderDTO {

    private int id;
    private int customerId;
    private int masterHandId;
    private int cost;
    private int serviceId;

    public static OrderDTO.OrderBuilder newBuilder(){
        return new OrderDTO().new OrderBuilder();
    }

    public class OrderBuilder {

        private int id;
        private int customerId;
        private int masterHandId;
        private int cost;
        private int servicesId;




        public OrderDTO.OrderBuilder setId(int id) {
            OrderDTO.this.id = id;
            return this;
        }

        public OrderDTO.OrderBuilder setCustomerId(int id) {
            OrderDTO.this.customerId = id;
            return this;
        }

        public OrderDTO.OrderBuilder setMasterHandId(int id) {
            OrderDTO.this.masterHandId = id;
            return this;
        }

        public OrderDTO.OrderBuilder setServicesId(int id) {
            OrderDTO.this.serviceId = id;
            return this;
        }

        public OrderDTO.OrderBuilder setCost(int cost) {
            OrderDTO.this.cost = cost;
            return this;
        }


        public OrderDTO build() {
            return OrderDTO.this;
        }
    }

    public static OrderDTO toDTO(Order order) {
        return  OrderDTO.newBuilder()
                .setId(order.getId())
                .setCustomerId(order.getCustomerId())
                .setMasterHandId(order.getMasterHandId())
                .setCost(order.getCost())
                .setServicesId(order.getServicesId())
                .build();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", masterHandId=" + masterHandId +
                ", cost=" + cost +
                ", servicesId=" + serviceId +

                '}';
    }

}
