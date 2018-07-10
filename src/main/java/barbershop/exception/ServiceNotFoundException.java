package barbershop.exception;

public class ServiceNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Service not found";
    }

}
