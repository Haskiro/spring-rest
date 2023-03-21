package com.github.haskiro.FirstRestApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + @ResponseBody над каждым методом
@RequestMapping("/api")
public class FirstRESTController {

    // @ResponseBody // для того, чтобы указать spring, что этот метод возвращает не представление, а данные
    @GetMapping("/sayHello")
    // Если возвращемое значение будет объект какого то класса,
    // то оно будет конвертировано в json с помощью Jackson
    public String sayHello() {
        return "Hello world";
    }
}
