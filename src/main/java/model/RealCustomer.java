package model;

public class RealCustomer extends Customer {
    private String firstName;
    private String lastName;
    private String fatherName;
    private String dateOfBirth;
    private String nationalCode;

    public RealCustomer(String id, String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.nationalCode = nationalCode;
    }

    public RealCustomer(String firstName, String lastName, String fatherName, String dateOfBirth, String nationalCode) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.nationalCode = nationalCode;
    }

    public RealCustomer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return "RealCustomer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                '}';
    }
}
