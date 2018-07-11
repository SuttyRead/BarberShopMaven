package barbershop.domain;

public class MasterHand  extends Person{

    public static final String HIRING = "hiring";
    public static final String EXPERIENCE = "experience";
    public static final String NUMBER_CERTIFICATE = "number_certificate_id";
    public static final String CERTIFICATE = "certificates.number_certificate";

    private String hiring;
    private double experience;
    private int numberCertificate;
    private int certificate;

    public MasterHand() {
    }

    public MasterHand(String firstName, String lastName, String middleName, String phoneNumber, String hiring, double experience) {
        super(firstName, lastName, middleName, phoneNumber);
        this.hiring = hiring;
        this.experience = experience;
    }

    public String getHiring() {
        return hiring;
    }

    public void setHiring(String hiring) {
        this.hiring = hiring;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public int getNumberCertificate() {
        return numberCertificate;
    }

    public void setNumberCertificate(int numberCertificate) {
        this.numberCertificate = numberCertificate;
    }



    @Override
    public String toString() {
        return "MasterHand(First name = " + getFirstName() + ", last name = " + getLastName() + "," +
                " middle name = " + getMiddleName() + ", phone number = " + getPhoneNumber() +
                ", hiring = " + getHiring() + ", experience = " + getExperience() + ", number certificate = " + getNumberCertificate() + ")";
    }
}
