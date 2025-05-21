package com.rbl.accounts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.rbl.accounts.mapper"})
@SpringBootApplication
public class AccountsApplication {

    public static void main(String[] args) {
        try {

            SpringApplication.run(AccountsApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
