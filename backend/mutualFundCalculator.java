public class mutualFunCalculator {
    public static double[] createArrayOfWorth(long apr, int years, double principal, double monthlyContribution){
        double[] values = new double[years*12];
        values[0] = principal;

        for(int i = 1; i < years*12; i++){
            values[i] = values[i-1] + monthlyContribution + (values[i-1] * apr/12/100);
        }
        return values;
    }

    public static double[] createArrayOfWorthWithDepreciation(long apr, int years, double principal, double monthlyContribution, long inflation){
        double[] values = new double[years*12];
        values[0] = principal;

        for(int i = 1; i < years*12; i++){
            values[i] = values[i-1] + monthlyContribution + (values[i-1] * (apr/12/100 - inflation/12/100));
        }
        return values;
    }
}
