package spring.spring_basics_practice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // No explicit @Bean methods needed - components are automatically detected by scanning
    // The component scan will find all classes with @Component, @Service, @Repository, @Controller annotations
    // The base package for scanning is the package of this class by default
}
