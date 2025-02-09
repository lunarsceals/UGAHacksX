package com.example.demo.backend;

public class car{
    String make;
    int year;

    public car(String make, int year){
        this.make = make;
        this.year = year;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}