package com.javatoai.clickhouse.service;

import com.javatoai.clickhouse.IActionService;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class CatActionService implements IActionService {
    @Override
    public String sayHello() {
        return "喵喵喵喵喵喵喵喵喵";
    }
}
