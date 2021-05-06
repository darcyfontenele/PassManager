package com.passmanager.domain.model;

import java.time.LocalDate;
import static java.util.Objects.nonNull;

public class PassCard {

    //SALDO REFERENTE A CONTA DO BANCO
    private int balance;

    private FareEnum passLevel;

    private LocalDate validDate;

    public PassCard(int balance) {
        this.balance = balance;
    }

    public PassCard(int balance, FareEnum passLevel, LocalDate validDate) {
        this.balance = balance;
        this.passLevel = passLevel;
        this.validDate = validDate;
    }

    public boolean chargeFare(FareEnum fare) {
        if(nonNull(this.passLevel) && this.passLevel.getValue() >= fare.getValue()) {
            if(nonNull(this.validDate) && this.validDate.isAfter(LocalDate.now())) {
                return true;
            }
        }
        if(this.balance - fare.getValue() < 0) {
            return false;
        }
        this.balance -= fare.getValue();
        this.passLevel = fare;
        switch(this.passLevel) {
            case AZONEUNIQUE:
            case BZONEUNIQUE:
                this.validDate = null;
                break;
            case AZONEDAILY:
            case BZONEDAILY:
                this.validDate = LocalDate.now().plusDays(1);
                break;
            case AZONEWEEKLY:
            case BZONEWEEKLY:
                this.validDate = LocalDate.now().plusWeeks(1);
                break;
            case AZONEMONTHLY:
            case BZONEMONTHLY:
                this.validDate = LocalDate.now().plusMonths(1);
                break;
        }
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public FareEnum getPassLevel() {
        return passLevel;
    }

    public void setPassLevel(FareEnum passLevel) {
        this.passLevel = passLevel;
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDate validDate) {
        this.validDate = validDate;
    }

}
