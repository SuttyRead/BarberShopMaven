package barbershop.domain;

public class Certificate {

    public static final String ID = "id";
    public static final String NUMBER_CERTIFICATE = "number_certificate";

    private int id;
    private int numberCertificate;

    public Certificate() {
    }

    public Certificate(int id, int numberCertificate) {
        this.id = id;
        this.numberCertificate = numberCertificate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberCertificate() {
        return numberCertificate;
    }

    public void setNumberCertificate(int numberCertificate) {
        this.numberCertificate = numberCertificate;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", numberCertificate=" + numberCertificate +
                '}';
    }
}
