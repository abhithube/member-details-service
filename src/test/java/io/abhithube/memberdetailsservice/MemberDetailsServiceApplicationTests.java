package io.abhithube.memberdetailsservice;

import io.abhithube.memberdetailsservice.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class MemberDetailsServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
