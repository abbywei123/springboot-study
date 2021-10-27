package com.yw;

import com.yw.pojo.User;
import com.yw.service.UserServiceImple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootHelloShiroApplicationTests {

    @Autowired
    UserServiceImple userService;

    @Test
    void contextLoads() {
        User user = userService.queryBYName("张三");
        System.out.println(user);
    }

}
