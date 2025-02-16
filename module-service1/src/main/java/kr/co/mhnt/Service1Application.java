package kr.co.mhnt;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.time.LocalDateTime;
import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class Service1Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Service1Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

    @PostConstruct
    public void timePrint() {
        LocalDateTime now = LocalDateTime.now();
        log.info("### Application initialized with timezone = {}", TimeZone.getDefault().getID());
        log.info("### 현재시간 = {}", now);
    }

}
