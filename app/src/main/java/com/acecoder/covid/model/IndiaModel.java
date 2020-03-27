package com.acecoder.covid.model;

public class IndiaModel {
    private String loc;
    private int confirmedCasesIndian;
    private int confirmedCasesForeigners;
    private int discharged;
    private int deaths;

    public IndiaModel() {
    }

    public IndiaModel(String loc, int confirmedCasesIndian, int confirmedCasesForeigners, int discharged, int deaths) {
        this.loc = loc;
        this.confirmedCasesIndian = confirmedCasesIndian;
        this.confirmedCasesForeigners = confirmedCasesForeigners;
        this.discharged = discharged;
        this.deaths = deaths;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(int confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public int getConfirmedCasesForeigners() {
        return confirmedCasesForeigners;
    }

    public void setConfirmedCasesForeigners(int confirmedCasesForeigners) {
        this.confirmedCasesForeigners = confirmedCasesForeigners;
    }

    public int getDischarged() {
        return discharged;
    }

    public void setDischarged(int discharged) {
        this.discharged = discharged;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
