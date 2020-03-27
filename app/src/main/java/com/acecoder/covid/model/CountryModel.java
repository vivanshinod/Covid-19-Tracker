package com.acecoder.covid.model;

import java.io.Serializable;

public class CountryModel {

    private int active;
    private int cases;
    private int casesPerOneMillion;
    private String country;
    private int critical;
    private int deaths;
    private int deathsPerOneMillion;
    private int recovered;
    private int todayCases;
    private int todayDeaths;


    public CountryModel() {
    }

    public CountryModel(int active, int cases, int casesPerOneMillion, String country, int critical, int deaths, int deathsPerOneMillion, int recovered, int todayCases, int todayDeaths) {
        this.active = active;
        this.cases = cases;
        this.casesPerOneMillion = casesPerOneMillion;
        this.country = country;
        this.critical = critical;
        this.deaths = deaths;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.recovered = recovered;
        this.todayCases = todayCases;
        this.todayDeaths = todayDeaths;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(int casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(int deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }
}
