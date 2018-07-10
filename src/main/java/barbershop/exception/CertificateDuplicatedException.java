package barbershop.exception;

public class CertificateDuplicatedException extends Exception {

    @Override
    public String getMessage() {
        return "Certificate duplicated";
    }

}
