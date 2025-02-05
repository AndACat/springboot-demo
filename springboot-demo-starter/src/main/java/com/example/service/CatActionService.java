package com.example.service;

import com.example.IActionService;
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
