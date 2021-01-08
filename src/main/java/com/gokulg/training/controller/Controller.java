package com.gokulg.training.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    public String result(){
        return "Hello World!";
    }

    @PostMapping("/postTest")
    public String getFromUrl(@RequestBody String content)
    {
        System.out.println("Coming in: "+content);
        return "Done";
    }
}
