package model;

import java.math.BigDecimal;

public class GrantCondition {
    private String id;
    private String name;
    private int minDuration;
    private int maxDuration;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private LoanType loanType;

    public GrantCondition() {
    }

    public GrantCondition(String name, int minDuration, int maxDuration, BigDecimal minAmount,
                          BigDecimal maxAmount) {
        this.name = name;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }
}
