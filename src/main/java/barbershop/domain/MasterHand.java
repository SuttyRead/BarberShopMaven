package barbershop.domain;

public class MasterHand  extends Person{

    public static final String HIRING = "hiring";
    public static final String EXPERIENCE = "experience";

    private String hiring;
    private double experience;

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

    @Override
    public String toString() {
        return "MasterHand(First name = " + getFirstName() + ", last name = " + getLastName() + "," +
                " middle name = " + getMiddleName() + ", phone number = " + getPhoneNumber() +
                ", hiring = " + getHiring() + ", experience = " + getExperience() + ")";
    }
}
