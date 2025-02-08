import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class JsonApiApplication {
    
    private final InvestmentService investmentService = new InvestmentService();

    public static void main(String[] args) {
        SpringApplication.run(JsonApiApplication.class, args);
    }

    @GetMapping("/investment")
    public String getInvestmentWorth() {
        double[] values = investmentService.createArrayOfWorth(5, 10, 1000, 100); // Example values
        return investmentService.createJsonObjectWithArray(values);
    }

    @GetMapping("/investmentWithDepreciation")
    public String getInvestmentWorthWithDepreciation() {
        double[] values = investmentService.createArrayOfWorthWithDepreciation(5, 10, 1000, 100, 2); // Example values
        return investmentService.createJsonObjectWithArray(values);
    }
}