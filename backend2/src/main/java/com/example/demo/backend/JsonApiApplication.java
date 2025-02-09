package com.example.demo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class JsonApiApplication<MyData> {
    
    private final InvestmentService investmentService = new InvestmentService();

    public static void main(String[] args) {
        SpringApplication.run(JsonApiApplication.class, args);
    }

    @GetMapping("/investment")
    public ResponseEntity<String> getInvestmentWorth() {
       // double[] values = investmentService.createArrayOfWorth(5, 10, 1000, 100); // Example values
       // return ResponseEntity.ok(Arrays.asList(Arrays.stream(values).boxed().toArray(Double[]::new)));
    //   ObjectMapper mapper = new ObjectMapper();
       monthlyValue[] values = investmentService.calculateMonthlyValues(11,0,20,1000,100);
       String jsonString = null;
        for(int i = 0; i < values.length; i++){
            jsonString += ("Month " + values[i].month + " Total: " + values[i].totalValue + "\n");
            }
        return ResponseEntity.ok(jsonString);
    }

    @GetMapping("/investmentWithDepreciation")
    public monthlyValue[] getInvestmentWorthWithDepreciation() {
        monthlyValue[] values = investmentService.calculateMonthlyValues(11,0,20,1000,100);
        //double[] values = investmentService.createArrayOfWorthWithDepreciation(5, 10, 1000, 100, 2); // Example values
        //String jsonResponse = investmentService.createJsonObjectWithArray(values);
        return values;
    }

    // @PostMapping("/data")
    // public ResponseEntity<MyData> postData(@RequestBody MyData data) {
    //     return ResponseEntity.ok(data);
    //     // return "Received data: " + receivedData.toString();
    // }
    
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:3000") // The origin of your React app
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}

}
