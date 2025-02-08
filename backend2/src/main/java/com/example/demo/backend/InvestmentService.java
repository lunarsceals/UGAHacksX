public class InvestmentService {
    
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

    public String createJsonObjectWithArray(double[] values) {
        StringBuilder jsonArray = new StringBuilder();
        jsonArray.append("[");

        for (int i = 0; i < values.length; i++) {
            jsonArray.append(values[i]);
            if (i < values.length - 1) {
                jsonArray.append(",");
            }
        }

        jsonArray.append("]");

        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("worthArray", jsonArray.toString());

        return jsonObject.toString().replace("=", ":");
    }
}