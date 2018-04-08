package com.huatuo.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @GetMapping(value = "/msg")
    public String msg() {
        return "product message";
    }

}
