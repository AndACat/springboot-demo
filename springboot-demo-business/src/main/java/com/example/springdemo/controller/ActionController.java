package com.example.springdemo.controller;

import com.example.IActionService;
import com.example.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/action")
public class ActionController {
    @Autowired
    private IActionService actionService;

    @RequestMapping("/doDog")
    public Response<String> doDogAction() {
        String msg = actionService.sayHello();
        return Response.success(msg);
    }
    @RequestMapping("/doCat")
    public Response<String> doCatAction() {
        String msg = actionService.sayHello();
        return Response.success(msg);
    }
}
