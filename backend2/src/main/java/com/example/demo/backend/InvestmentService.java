package com.example.demo.backend;

import java.util.HashMap;
import java.util.Map;

public class InvestmentService {

        // This creates an array of monthlyValue objects that store the values of the investment.
    public static monthlyValue[] calculateMonthlyValues(long apr, long depreciatedValue, int years, double principal, double monthlyContribution){
        monthlyValue[] values = new monthlyValue[years*12+1];
        values[0] = new monthlyValue(principal, principal, principal,0);
        for(int i = 1; i < years*12+1; i++){
            values[i] = new monthlyValue(values[i-1].totalPrincipal + monthlyContribution, values[i-1].totalValue + monthlyContribution + (values[i-1].totalValue * apr/12/100), values[i-1].totalValue + monthlyContribution + (values[i-1].totalValue * apr-depreciatedValue/12/100), i);
        }
        return values;
    }
    
    public double[] createArrayOfWorth(long apr, int years, double principal, double monthlyContribution) {
        double[] values = new double[years * 12];
        values[0] = principal;

        for (int i = 1; i < years * 12; i++) {
            values[i] = values[i - 1] + monthlyContribution + (values[i - 1] * apr / 12 / 100);
        }
        return values;
    }

    public double[] createArrayOfWorthWithDepreciation(long apr, int years, double principal, double monthlyContribution, long inflation) {
        double[] values = new double[years * 12];
        values[0] = principal;

        for (int i = 1; i < years * 12; i++) {
            values[i] = values[i - 1] + monthlyContribution + (values[i - 1] * (apr / 12 / 100 - inflation / 12 / 100));
        }
        return values;
    }

    public String createJsonObjectWithArray(monthlyValue[] values) {
        StringBuilder jsonArray = new StringBuilder();
        jsonArray.append("[");

        int year = 0;
        for (int i = 0; i < values.length; i++) {
            if(i+1 % 12 == 0){
            jsonArray.append("Year: " + year + " ," + (int)values[i].totalValue);
            year++;
            if (i < values.length - 1) {
                jsonArray.append(",");
            }
        }
        }

        jsonArray.append("]");

        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("worthArray", jsonArray.toString());

        return jsonObject.toString().replace("=", ":");
    }
}
