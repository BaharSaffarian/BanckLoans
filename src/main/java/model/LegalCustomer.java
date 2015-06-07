package model;

/**
 * Created by DOTIN SCHOOL 3 on 5/26/2015.
 */
public class LegalCustomer extends Customer {
    private String companyName;
    private String registerDate;
    private String economicCode;

    public LegalCustomer(String id, String companyName, String registerDate, String economicCode) {
        super(id);
        this.companyName = companyName;
        this.registerDate = registerDate;
        this.economicCode = economicCode;
    }

    public LegalCustomer(String companyName, String registerDate, String economicCode) {
        this.companyName = companyName;
        this.registerDate = registerDate;
        this.economicCode = economicCode;
    }

    public LegalCustomer() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    @Override
    public String toString() {
        return "LegalCustomer{" +
                "companyName='" + companyName + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", economicCode='" + economicCode + '\'' +
                '}';
    }
}
