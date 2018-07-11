package barbershop.domain;

public class Services {

    public static final String ID = "id";
    public static final String SERVICE = "service_id";
    public static final String COST = "cost";
    public static final String DURATION = "duration";


    private int id;
    private String service;
    private int cost;
    private int duration;

    public Services() {
    }

    public Services(int id, String serviceList, int cost, int duration) {
        this.id = id;
        this.service = serviceList;
        this.cost = cost;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", service=" + service +
                ", cost=" + cost +
                ", duration=" + duration +
                '}';
    }
}
