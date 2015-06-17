package model;

import java.math.BigDecimal;

public class LoanFile {
    private String id;
    private String customerId;
    private String loanTypeId;
    private int duration;
    private BigDecimal amount;

    public LoanFile() {
    }

    public LoanFile(String customerId, String loanTypeId, int duration, BigDecimal amount) {
        this.customerId = customerId;
        this.loanTypeId = loanTypeId;
        this.duration = duration;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getLoanTypeId() {
        return loanTypeId;
    }

    public int getDuration() {
        return duration;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setLoanTypeId(String loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
