package org.xiaom.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.xiaom.vhr.mapper")
public class VhrserverWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrserverWebApplication.class, args);
    }

}
