package qa.co.qnb;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.netflix.config.ConfigurationManager;

import qa.co.qnb.filters.ErrorFilter;
import qa.co.qnb.filters.PostFilter;
import qa.co.qnb.filters.PreFilter;
import qa.co.qnb.filters.RouteFilter;
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	@Bean
	public CorsFilter corsFilter(){
		 final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		    final CorsConfiguration config = new CorsConfiguration();
		    config.setAllowCredentials(true);
		    config.addAllowedOrigin("*");
		    config.addAllowedHeader("*");
		    config.addAllowedMethod("OPTIONS");
		    config.addAllowedMethod("HEAD");
		    config.addAllowedMethod("GET");
		    config.addAllowedMethod("PUT");
		    config.addAllowedMethod("POST");
		    config.addAllowedMethod("DELETE");
		    config.addAllowedMethod("PATCH");
		    source.registerCorsConfiguration("/**", config);
		    return new CorsFilter(source);
	}
	 @PostConstruct
	   void disableHystrix() {
	        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.enabled", false);
	        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.timeout.enabled", false);
	        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.thread.interruptOnTimeout", false);
	        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", 60000);
	        ConfigurationManager.getConfigInstance().setProperty("ribbon.ReadTimeout", 6000);

	    }

}
