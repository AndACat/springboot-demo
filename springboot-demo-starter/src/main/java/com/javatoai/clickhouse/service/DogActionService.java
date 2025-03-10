package com.javatoai.clickhouse.service;

import com.javatoai.clickhouse.IActionService;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class DogActionService implements IActionService {
    @Override
    public String sayHello() {
        return "汪汪汪汪汪汪汪汪汪汪汪";
    }
}
