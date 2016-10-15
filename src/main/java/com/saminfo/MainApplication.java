package com.saminfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Created by sambit on 10/12/2016.
 */

@SpringBootApplication
/*@Configuration
@ComponentScan
@EnableAutoConfiguration*/
public class MainApplication {
    public static void main(String... args){
        SpringApplication.run(MainApplication.class, args);
    }
}
