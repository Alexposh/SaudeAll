package com.saudeall.app;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer{
    private final JWTValidationInterceptor jwtValidationInterceptor;

    @Override
    public void addCorsMappings( CorsRegistry registry) {
        registry.addMapping("/api/v1/**")
                .allowedOrigins("*")
                .allowedMethods("*")
//                .allowCredentials(true)
                .allowedHeaders("*");
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry){
        registry.addInterceptor(jwtValidationInterceptor)
                .excludePathPatterns("/api/v1/doctors");
    }
}
