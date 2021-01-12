package com.gokulg.training.controller;

import com.gokulg.training.friendsname.FriendsName;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class Controller {
    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    public String result() {
        return "Hello World!";
    }

    @PostMapping("/postTest")
    public String getFromUrl(@RequestBody String content) {
        System.out.println("Coming in: " + content);
        return "Done";
    }

    FriendsName localVar;

    Controller() {
        localVar = new FriendsName();
        localVar.friendsName.put(1, "Raja");
        localVar.friendsName.put(2, "Ravi");
        localVar.friendsName.put(3, "Rahul");
        localVar.friendsName.put(4, "Reena");
        localVar.friendsName.put(5, "Riya");
    }

    @GetMapping("/friendsnames/")
    public Set<Map.Entry<Integer, String>> printFriendsNames() {
        return FriendsName.friendsName.entrySet();
    }


    @RequestMapping(value = "/addentry", method = RequestMethod.POST)

    public void addEntry(@RequestBody HashMap<Integer, String> input) {
        localVar.friendsName.putAll(input);
    }

    @RequestMapping(value = "/deleteentry", method = RequestMethod.POST)

    public void addEntry(@RequestBody int input) {
        localVar.friendsName.remove(input);
    }

}