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
public class CommonApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CommonApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

    @PostConstruct
    public void timePrint() {
        LocalDateTime now = LocalDateTime.now();
        log.info("### CommonApplication initialized with timezone = {}", TimeZone.getDefault().getID());
        log.info("### 현재시간 = {}", now);
    }

}
