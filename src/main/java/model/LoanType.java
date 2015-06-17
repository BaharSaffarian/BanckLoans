package model;

import java.util.Set;

public class LoanType {
    private String id;
    private String name;
    private int interestRate;
    private Set<GrantCondition> grantConditions;

    public LoanType() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public Set<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public void setGrantConditions(Set<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
    }
}
