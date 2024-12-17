package com.example.ratelimiter;

//import com.example.ratelimiter.filter.RateLimiterFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RatelimiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatelimiterApplication.class, args);

	}

//	@Bean
//	public FilterRegistrationBean<RateLimiterFilter> rateLimitingFilter() {
//		FilterRegistrationBean<RateLimiterFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new RateLimiterFilter());
//		registrationBean.addUrlPatterns("*"); // Register filter for API endpoints
//		return registrationBean;
//	}



}
