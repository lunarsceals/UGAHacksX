package com.example.demo.backend;

// This class is used to store the totalPrincipal, totalInterest, totalValue, and the 
// month of growth (I.E. the 11th month of growth). This should make it easier to store
// data we plan to chart and send it to front end as JSON objects.
public class monthlyValue {
    
    double totalPrincipal;
    double totalValue;
    double depreciatedValue;
    int month;

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
