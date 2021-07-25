package com.junit.junitrestcontroller.controller;

import com.junit.junitrestcontroller.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    HomeService homeService;

    @Autowired
    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }

    @PostMapping ("/")
    public String index(@RequestBody String name){
        return homeService.nameCheck(name);
    }
}
