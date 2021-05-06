package com.passmanager.domain.model;

public class Station {

    private ZoneEnum zone;

    public Station(ZoneEnum zone) {
        this.setZone(zone);
    }

    public boolean enter(PassCard passCard, FareEnum fare) {
        if(zone.equals(ZoneEnum.B) && (fare.equals(FareEnum.AZONEUNIQUE) ||
            fare.equals(FareEnum.AZONEDAILY) || fare.equals(FareEnum.AZONEWEEKLY) ||
            fare.equals(FareEnum.AZONEMONTHLY))) {
            return false;
        }
        return passCard.chargeFare(fare);
    }

    public ZoneEnum getZone() {
        return zone;
    }

    public void setZone(ZoneEnum zone) {
        this.zone = zone;
    }

}
