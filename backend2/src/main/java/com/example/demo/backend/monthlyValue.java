package com.example.demo.backend;

// This class is used to store the totalPrincipal, totalInterest, totalValue, and the 
// month of growth (I.E. the 11th month of growth). This should make it easier to store
// data we plan to chart and send it to front end as JSON objects.
public class monthlyValue {
    
    double totalPrincipal;
    double totalValue;
    double depreciatedValue;
    int month;

    public double getTotalPrincipal() {
        return this.totalPrincipal;
    }

    public void setTotalPrincipal(double totalPrincipal) {
        this.totalPrincipal = totalPrincipal;
    }

    public double getTotalValue() {
        return this.totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getDepreciatedValue() {
        return this.depreciatedValue;
    }

    public void setDepreciatedValue(double depreciatedValue) {
        this.depreciatedValue = depreciatedValue;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    // Creates on object with depreciated values stored
    public monthlyValue(double totalPrincipal, double totalValue, double depreciatedValue, int month){
        this.month = month;
        this.totalPrincipal = totalPrincipal;
        this.totalValue = totalValue;
        this.depreciatedValue = depreciatedValue;
    }

    // Creates an object without depreciated values stored
    public monthlyValue(double totalPrincipal, double totalValue, long apr, int month){
        this.month = month;
        this.totalPrincipal = totalPrincipal;
        this.totalValue = totalValue;
    }
    
}
