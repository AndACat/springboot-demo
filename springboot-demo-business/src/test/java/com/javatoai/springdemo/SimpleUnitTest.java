package com.javatoai.springdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 */
@Slf4j
public class SimpleUnitTest {
    @Test
    public void test() {
        List<String> passwordList = Arrays.asList("hello1H#666666666", "hello  1H#6666666", "hello2h#666666666",
                "hello3h6666666666", "HELLO3H6666666666", "hellohellohello", "hello1H#666666666666666666");
        for (String password : passwordList) {
            boolean matches = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{12,20}$", password);
            log.info("密码：{}   长度: {}    是否匹配: {}", password, password.length(), matches);
        }
    }
}
