package com.rbl.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountsApplicationTests {

    @Test
    void contextLoads() {
        Double number = 0.000000000000001;
        System.out.println(Math.abs(number) < 0.00000000000001);
    }

}
