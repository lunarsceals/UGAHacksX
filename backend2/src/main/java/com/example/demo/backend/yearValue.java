package com.example.demo.backend;

public class yearValue {
    int value;
    int year;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
     public yearValue(int value, int year){
         this.value = value;
         this.year = year;
     }
     
}
